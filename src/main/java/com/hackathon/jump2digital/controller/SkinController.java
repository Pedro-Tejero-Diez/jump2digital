package com.hackathon.jump2digital.controller;

import com.hackathon.jump2digital.document.Player;
import com.hackathon.jump2digital.document.Skin;
import com.hackathon.jump2digital.service.Jump2DigitalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/skins")
public class SkinController {
    @Autowired
    Jump2DigitalServiceImp service;
    @GetMapping("/new")
    public String newPlayer(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "new_player";
    }

   /* @GetMapping("/")
    public String jugadores(Model model) {
        List<Jugador> jugadores = jugadorservice.getAllJugador();
        model.addAttribute("jugadores",
                jugadores.stream().map(JugadorMapper::toJugadorDTO).collect(Collectors.toList()));
        return "listado_jugadores";
    }*/

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
}

