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

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/skins")
public class SkinController {
    @Autowired
    PlayerServiceImp service;
    @Autowired
    PlayerSkinServiceImp playerskinservice;

    @GetMapping("/new")
    public String newPlayer(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "new_player";
    }
    @GetMapping("/login")
    public String login (Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "login";
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

    @GetMapping("/{player_id}/available")
    public String listSkins(@PathVariable(value = "player_id")
                                String player_id, @ModelAttribute("player") Player player,
                            Model model) throws IOException {
        if (service.existsById(player_id)) {
            List<Skin> skins = service.readJsonFile();
            model.addAttribute("skins", skins);
            model.addAttribute("player", player);
            return "skins";
        } else {
                return "not_found";
        }
    }
    @GetMapping("/skins/buy/")
    public String butSkinPlayer (@ModelAttribute ("player") Player player,
                                 @ModelAttribute("skin") Skin skin, Model model) {
    playerskinservice.buySkinById(player, skin);
    model.addAttribute("player_id", player.getPlayer_id());
        return "redirect:/Skins/{player_id}/myskins";
    }

	@GetMapping("/{player_id}/myskins")
	public String playerSkins(@PathVariable(value = "player_id") 
	String player_id, Model model) {

		try {
			Player player = service.getPlayerById(player_id);
			List<PlayerSkin> playerskin =  playerskinservice
            		.getAllPlayerSkinByPlayer(player_id);
			if (player != null) {
				playerDTO playerdto = DtoConverter.toPlayerDTO(player);
				model.addAttribute("playerskin",playerskin);
				

				model.addAttribute("player", playerdto);
				return "player";
			} else
				return "no_encontrado";
		} catch (Exception e) {
			return "error";
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

}