package com.grupo2.jump2hackathon.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo2.jump2hackathon.documents.Barrio;
import com.grupo2.jump2hackathon.repository.BarrioRepository;
import io.github.classgraph.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BarrioService {
    private final BarrioRepository barrioRepository;

    public List<Barrio> readJsonFile() throws IOException {
        Resource resource = new ClassPathResource("/barrios.json");
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = resource.getInputStream();
        return objectMapper.readValue(inputStream,
                new TypeReference<List<Barrio>>() {
                });
    }
    public List<Barrio> getAllBarrios() {
        return barrioRepository.findAll();
    }

    public Optional<Barrio> getBarrioById(UUID id) {

        return barrioRepository.findById(id);
    }

}
