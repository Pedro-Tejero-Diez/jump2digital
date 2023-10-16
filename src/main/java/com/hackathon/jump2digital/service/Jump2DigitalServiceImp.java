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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Jump2DigitalServiceImp {
    @Autowired
    PlayerRepository playerrepository;

    /*  @Autowired
     JsonFileProperties jsonprops;
    public List<Skin> readJsonFile() throws IOException {
         ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.readValue(new File(jsonprops.getFilePath()),
                 new TypeReference<List<Skin>>() {});
     }
 */
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
    public void buySkin(Player player, int  skin_id) throws IOException {
        List<Skin> skins = readJsonFile();
       if (player.getSkins()!= null) {
           player.getSkins().add(skins.get(skin_id));
           playerrepository.save(player);
       } else {
           List<Skin> player_skins = new ArrayList<Skin>() ;
           player_skins.add(skins.get(skin_id));
           player.setSkins(player_skins);
           playerrepository.save(player);
       }
    }
}