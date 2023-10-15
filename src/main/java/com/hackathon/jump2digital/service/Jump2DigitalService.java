package com.hackathon.jump2digital.service;

import com.hackathon.jump2digital.document.Player;
import com.hackathon.jump2digital.document.Skin;

import java.util.List;

public interface Jump2DigitalService {
    public List<Skin> readJsonFile();
    public void savePlayer(Player player);
}
