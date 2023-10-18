package com.hackathon.jump2digital.controller;

import com.hackathon.jump2digital.document.Player;
import com.hackathon.jump2digital.document.PlayerSkin;
import com.hackathon.jump2digital.document.Skin;
import com.hackathon.jump2digital.dto.playerDTO;
import com.hackathon.jump2digital.helper.DtoConverter;
import com.hackathon.jump2digital.service.Jump2DigitalServiceImp;
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
    Jump2DigitalServiceImp service;
    @Autowired
    PlayerSkinServiceImp playerskinservice;

    @GetMapping("/new")
    public String newPlayer(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "new_player";
    }

    @PostMapping("/add")
    public String savePlayer(@ModelAttribute("player") Player player) {
        try {
            service.savePlayer(player);

            return "success";

        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/available")
    public String listSkins(Model model) throws IOException {
        List<Skin> skins = service.readJsonFile();
        model.addAttribute("skins", skins);
        return "skins"; // Return the Thymeleaf template name
    }

    @GetMapping("/{player_id}/myskins")
    public String playerSkins(@PathVariable(value = "player_id") String player_id,
                              RedirectAttributes ra, Model model) {

            if (service.getPlayerById(player_id)!=null) {
                List<PlayerSkin> playerskin =  service.getPlayerById(player_id)
                        .getPlayerSkins();
            ra.addFlashAttribute("playerskin",playerskin);
            return "redirect:/Skins/{player_id}/playerskins";
            } else return "error";

    }

}