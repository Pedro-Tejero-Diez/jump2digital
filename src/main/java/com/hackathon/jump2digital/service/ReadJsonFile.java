package com.hackathon.jump2digital.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.jump2digital.document.Skin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadJsonFile {
    public List<Skin> readJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath),
                new TypeReference<List<Skin>>() {});
    }
}
