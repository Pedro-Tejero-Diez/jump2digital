package com.hackathon.jump2digital.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.jump2digital.document.Player;
import com.hackathon.jump2digital.document.Skin;
import com.hackathon.jump2digital.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImp {
    @Autowired
    PlayerRepository playerrepository;

    public List<Skin> readJsonFile() throws IOException {
        Resource resource = new ClassPathResource("skins.json");
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = resource.getInputStream();
        return objectMapper.readValue(inputStream,
                new TypeReference<List<Skin>>() {
                });
    }

    public void savePlayer(Player player) {
        playerrepository.save(new Player(player.getRegdate(), player.getName(), player.getPwd()));

    }

    public Player getPlayerById(String player_id) {

        Optional<Player> player = playerrepository.findById(player_id);
        return player.orElse(null);
    }

    public Boolean existsById(String player_id) {
        return playerrepository.existsById(player_id);
    }


}