package com.hackathon.jump2digital.service;

import com.hackathon.jump2digital.document.Player;
import com.hackathon.jump2digital.document.PlayerSkin;
import com.hackathon.jump2digital.document.Skin;

import java.util.List;
public interface PlayerSkinService {

    List<PlayerSkin> getAllPlayerSkin();

    //void deletePlayerSkin(String playerSkin_id);

    void savePlayerSkin(PlayerSkin playerSkin);

    List<PlayerSkin> getAllPlayerSkinByPlayer(String player_id);

   // void deletePlayerSkin(String playerSkin_id);

    public void buySkinById(Player player, Skin skin);
}
