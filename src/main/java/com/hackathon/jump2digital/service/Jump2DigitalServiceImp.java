package com.hackathon.jump2digital.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.jump2digital.document.Skin;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Service
public class Jump2DigitalServiceImp {
    /*  @Autowired
     JsonFileProperties jsonprops;
    public List<Skin> readJsonFile() throws IOException {
         ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.readValue(new File(jsonprops.getFilePath()),
                 new TypeReference<List<Skin>>() {});
     }
 */
 public List<Skin> readJsonFile() throws IOException {
        Resource resource = new ClassPathResource("skins.json");
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = resource.getInputStream();
        return objectMapper.readValue(inputStream,
                new TypeReference<List<Skin>>() {});
    }
}
