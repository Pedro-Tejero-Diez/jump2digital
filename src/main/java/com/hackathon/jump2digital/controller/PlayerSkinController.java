package com.hackathon.jump2digital.controller;

import com.hackathon.jump2digital.document.PlayerSkin;
import com.hackathon.jump2digital.service.PlayerServiceImp;
import com.hackathon.jump2digital.service.PlayerSkinServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Skins")
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
        public String playerskinsscreen(@PathVariable("playerskin_id") String id,
                                        @ModelAttribute("playerskin") PlayerSkin playerskin,
                                     Model model) {
            return "playerskin";
        }
    }