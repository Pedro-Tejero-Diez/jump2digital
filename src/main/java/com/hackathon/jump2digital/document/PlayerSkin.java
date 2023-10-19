package com.hackathon.jump2digital.document;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="playerskins")
public class PlayerSkin {

        @Id
        private String player_skin_id;
        private LocalDate regdate;
        private Skin playerSkin;
        @DocumentReference(lazy=true)
        private Player player;

        public PlayerSkin(LocalDate regdate, Player player) {
                this.regdate=regdate;
                this.player=player;
        }
        public PlayerSkin(Player player, Skin playerskin) {
                this.regdate=LocalDate.now();
                this.player=player;
                this.playerSkin=playerskin;
        }

}
