package com.hackathon.jump2digital.controller;

import com.hackathon.jump2digital.document.Player;
import com.hackathon.jump2digital.document.PlayerSkin;
import com.hackathon.jump2digital.document.Skin;
import com.hackathon.jump2digital.dto.playerDTO;
import com.hackathon.jump2digital.helper.DtoConverter;
import com.hackathon.jump2digital.service.PlayerServiceImp;
import com.hackathon.jump2digital.service.PlayerSkinServiceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/skins")
public class SkinController {
    @Autowired
    PlayerServiceImp service;
    @Autowired
    PlayerSkinServiceImp playerskinservice;

    //WORKING
    @GetMapping("/new")
    public String newPlayer(Model model) {
        model.addAttribute("player", new Player());
        return "new_player";
    }

    @GetMapping("/login")
    public String login(@RequestParam ("skinId") String id, Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("skinId", id);
        return "login";
    }

    @GetMapping("/lookforplayer")
    public String lookforplayer(@ModelAttribute Player player,
                                @RequestParam String skinId, RedirectAttributes ra,
                                Model model) throws IOException {

        if (service.findByName(player.getName()) != null) {
        ra.addAttribute("player", player);
        
        int skinIdAsInt = Integer.parseInt(skinId);
        String redirectUrl = "redirect:/skins/buy?skinId=" + skinIdAsInt;

        return redirectUrl;
            //return "redirect:skins/buy?skinId=skinId";
        } else return "new_player";
    }

    @PostMapping("/add")
    public String savePlayer(@ModelAttribute("player") Player player) {
        try {
            if (service.findPlayerById(player.getPlayer_id()).isEmpty()) {
                service.savePlayer(player);
                return "redirect: skins/buy";
            } else return "oldplayer";

        } catch (Exception e) {
            return "error";
        }
    }

    //WORKING
    @GetMapping("/available")
    public String listSkins(Model model) throws IOException {
        List<Skin> skins = service.readJsonFile();
        model.addAttribute("skins", skins);
        model.addAttribute("player", new Player());
        model.addAttribute("Skin", new Skin());
        return "skins";
    }

    //WORKING
    @GetMapping("/{player_id}/myskins")
    public String playerSkins(@PathVariable(value = "player_id")
                              String player_id, Model model) {

        try {
            Player player = service.getPlayerById(player_id);
            List<PlayerSkin> playerskin = playerskinservice
                    .getAllPlayerSkinByPlayer(player_id);
            if (player != null) {
                playerDTO playerdto = DtoConverter.toPlayerDTO(player);
                model.addAttribute("playerskin", playerskin);


                model.addAttribute("player", playerdto);
                return "player";
            } else
                return "no_encontrado";
        } catch (Exception e) {
            return "error";
        }
    }
}

	
    /* esto es el redirect que use para hacer una nueva jugada y guardarla
     * @PostMapping("/{player_id}/myskins")
    public String playerSkins(@PathVariable(value = "player_id") String player_id,
                              RedirectAttributes ra, Model model) {

            if (service.getPlayerById(player_id)!=null) {
                List<PlayerSkin> playerskin =  playerskinservice
                		.getAllPlayerSkinByPlayer(player_id);
            ra.addFlashAttribute("playerskin",playerskin);
            return "redirect:/Skins/{player_id}/playerskins";
            } else return "error";

    }*/
