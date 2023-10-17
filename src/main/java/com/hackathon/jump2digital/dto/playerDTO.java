package com.hackathon.jump2digital.dto;

import com.hackathon.jump2digital.document.PlayerSkin;
import com.hackathon.jump2digital.document.Skin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class playerDTO {
    private String player_id;
    private String name;
    private List<PlayerSkin> skins;


}
