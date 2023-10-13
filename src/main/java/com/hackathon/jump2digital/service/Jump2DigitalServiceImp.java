package com.hackathon.jump2digital.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.jump2digital.configuration.JsonFileProperties;
import com.hackathon.jump2digital.document.Skin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class Jump2DigitalServiceImp {
    @Autowired
    JsonFileProperties jsonprops;
    public List<Skin> readJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(jsonprops.getFilePath()),
                new TypeReference<List<Skin>>() {});
    }
}
