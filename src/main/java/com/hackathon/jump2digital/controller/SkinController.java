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
    
    //WORKING
    @GetMapping("/new")
    public String newPlayer(Model model) {
        model.addAttribute("player", new Player());
        return "new_player";
    }
    @GetMapping("/login")
    public String login (@ModelAttribute Skin skin, Model model) {
        model.addAttribute("player", new Player());
        return "login";
    }

    @GetMapping("/lookforplayer")
    public String lookforplayer (@ModelAttribute Player player, Model model) {

        if (service.findByName(player.getName()) != null) {
            model.addAttribute("playerskin",
                    playerskinservice.getAllPlayerSkinByPlayer(player.getPlayer_id()));
            return "playerskins";
        } else return "not_found";
    }

    @PostMapping("/add")
    public String savePlayer(@ModelAttribute("player") Player player) {
        try {
        	if (service.findPlayerById(player.getPlayer_id()).isEmpty()) {
            service.savePlayer(player);
            return "success";
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
            return "skins";
    }
    @GetMapping("/skins/buy/")
    public String butSkinPlayer (@ModelAttribute ("player") Player player,
                                 @ModelAttribute("skin") Skin skin, Model model) {
    playerskinservice.buySkinById(player, skin);
    model.addAttribute("player_id", player.getPlayer_id());
        return "redirect:/Skins/{player_id}/myskins";
    }
    //WORKING
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
