package com.hackathon.jump2digital.controller;

import com.hackathon.jump2digital.document.Skin;
import com.hackathon.jump2digital.service.Jump2DigitalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/skins")
public class SkinController {
    @Autowired
    Jump2DigitalServiceImp service;

@GetMapping("/available")
    public String listSkins(Model model) throws IOException {
        List<Skin> skins = service.readJsonFile();
        model.addAttribute("skins", skins);
        return "skins"; // Return the Thymeleaf template name
    }
}

