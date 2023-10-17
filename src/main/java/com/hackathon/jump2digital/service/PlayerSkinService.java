package com.hackathon.jump2digital.service;

import com.hackathon.jump2digital.document.PlayerSkin;

import java.util.List;
public interface PlayerSkinService {

    List<PlayerSkin> getAllPlayerSkin();

    void deletePlayerSkin(String playerSkin_id);

    void savePlayerSkin(PlayerSkin playerSkin);

    List<PlayerSkin> getAllPlayerSkinByPlayer(String player_id);

   // void deletePlayerSkin(String playerSkin_id);
}
