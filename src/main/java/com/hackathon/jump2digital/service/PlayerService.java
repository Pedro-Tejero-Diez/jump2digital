package com.hackathon.jump2digital.service;

import com.hackathon.jump2digital.document.Player;
import com.hackathon.jump2digital.document.Skin;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public List<Skin> readJsonFile();
    public void savePlayer(Player player);
    public void getPlayerById(String player_id);
    public void existsById(String player_id);
    public Player findByName(String player_name);
    public Optional<Player> findPlayerById(String player_id);
}
