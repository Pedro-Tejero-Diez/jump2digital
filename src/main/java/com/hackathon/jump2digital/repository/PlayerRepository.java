package com.hackathon.jump2digital.repository;

import com.hackathon.jump2digital.document.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

    public interface PlayerRepository extends MongoRepository<Player, String> {

        void deleteById(String playerId);

        Player findByName(String player_name);
    }
