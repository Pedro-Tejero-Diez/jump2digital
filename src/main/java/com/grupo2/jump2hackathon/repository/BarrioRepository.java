package com.grupo2.jump2hackathon.repository;

import com.grupo2.jump2hackathon.documents.Barrio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BarrioRepository extends MongoRepository<Barrio, UUID> {
}
