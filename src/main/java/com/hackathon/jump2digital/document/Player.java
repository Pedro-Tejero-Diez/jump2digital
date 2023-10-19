package com.hackathon.jump2digital.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection="players")
@Getter
@Setter
public class Player {
        @Id
        private String player_id;
        private LocalDate regdate;
        private String name;
        private String pwd;


        public Player(LocalDate regdate, String name, String pwd) {
           this.regdate=LocalDate.now();
           this.name=name;
           this.pwd=pwd;

        }

}
