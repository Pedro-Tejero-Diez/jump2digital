package com.hackathon.jump2digital.repository;

import java.util.List;

import com.hackathon.jump2digital.document.PlayerSkin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PlayerSkinRepository extends MongoRepository<PlayerSkin, String> {

        @Query("{ 'player' : {'$oid' : ?0}}")
        List<PlayerSkin> findAllByPlayer_id(String player_id);
}
