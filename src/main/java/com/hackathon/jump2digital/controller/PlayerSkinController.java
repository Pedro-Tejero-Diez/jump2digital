package com.hackathon.jump2digital.controller;

import com.hackathon.jump2digital.document.Player;
import com.hackathon.jump2digital.document.PlayerSkin;
import com.hackathon.jump2digital.document.Skin;
import com.hackathon.jump2digital.service.PlayerServiceImp;
import com.hackathon.jump2digital.service.PlayerSkinServiceImp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/skins")
public class PlayerSkinController {

        @Autowired
        PlayerSkinServiceImp playerskinservice;
        @Autowired
        PlayerServiceImp playerservice;

        /*@GetMapping("/{jugador_id}/delete")
        public String borrarListaJugadas(@PathVariable(value = "jugador_id") String jugador_id) {
            try {
                jugadaservice.eliminarJugadas(jugador_id);

            } catch (Exception e) {
                return "error";
            }
            return "exito";
        }*/
        //WORKING
        @GetMapping("/{player_id}/playerskins")
        public String playerskinsscreen(@PathVariable("player_id") String id,
                                        @ModelAttribute("playerskin") List<PlayerSkin> playerskin,
                                     Model model) {
            return "playerskins";
        }
        
        @GetMapping("getskin/{skin_id}")
        public String playerskinsscreen(@PathVariable("skin_id") String id,
                                        @ModelAttribute("playerskin") PlayerSkin playerskin,
                                     Model model) {
            return "playerskin";
        }

    @GetMapping("/buy")
    public String butSkinPlayer(@ModelAttribute("player") Player player,
    		@RequestParam String skinId,
                                RedirectAttributes ra) throws IOException {
    	int skinIdAsInt = Integer.parseInt(skinId);
    	Skin skin = playerservice.readJsonFile().get(skinIdAsInt);
        playerskinservice.buySkinById(player, skin);
        ra.addAttribute("player_id", player.getPlayer_id());
        return "redirect:/Skins/{player_id}/myskins";
    }
    }