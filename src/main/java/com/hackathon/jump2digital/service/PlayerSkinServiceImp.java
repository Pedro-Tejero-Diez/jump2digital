package com.hackathon.jump2digital.service;


import java.util.List;
import java.util.Optional;

import com.hackathon.jump2digital.document.PlayerSkin;
import com.hackathon.jump2digital.document.Player;
import com.hackathon.jump2digital.document.Skin;
import com.hackathon.jump2digital.repository.PlayerRepository;
import com.hackathon.jump2digital.repository.PlayerSkinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerSkinServiceImp implements PlayerSkinService {

        @Autowired
        PlayerSkinRepository playerskinrepository;
        @Autowired
        PlayerRepository playerrepository;

        @Override
        public List<PlayerSkin> getAllPlayerSkin() {

            return playerskinrepository.findAll();
        }

        @Override
        public List<PlayerSkin> getAllPlayerSkinByPlayer(String player_id) {

            return playerskinrepository.findAllByPlayer_id(player_id);
        }

        /*@Override
        public void deletePlayerSkin(String playerSkin_id) {

            Optional<PlayerSkin> playerSkin = playerskinrepository.findById(playerSkin_id);
            if (playerSkin.isPresent()) {

            Optional <Player> player =
                    playerrepository.findById(playerSkin.get().getPlayer().getPlayer_id());

            if (player.isPresent()) {

                Player player1 = player.get();
                for (int i = 0; i<player1.getPlayerSkins().size(); i++) {
                    playerskinrepository.delete(player1.getPlayerSkins().get(i));
                }
            }
            }

        }*/

        @Override
        public void buySkinById(Player player, Skin skin){

                playerskinrepository.save(new PlayerSkin(player, skin));
        }

        @Override
        public void savePlayerSkin(PlayerSkin playerSkin) {

            /*Player player =
                    playerrepository.findById(playerSkin.getPlayer().getPlayer_id()).get();

            PlayerSkinRepository.save(new PlayerSkin(playerSkin.getRegdate(), player));*/
        }

}
