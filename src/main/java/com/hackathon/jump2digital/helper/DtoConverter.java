package com.hackathon.jump2digital.helper;

import com.hackathon.jump2digital.document.Player;
import com.hackathon.jump2digital.dto.playerDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class DtoConverter {


    public static playerDTO toPlayerDTO(Player player) {



        return new playerDTO(player.getPlayer_id(),
                player.getName(), player.getPlayerSkins());
    }

    public static Player toPlayer(playerDTO playerdto, String pwd) {

        LocalDate regdate = LocalDate.now();

        return new Player(regdate, playerdto.getName(), pwd);

    }
}
