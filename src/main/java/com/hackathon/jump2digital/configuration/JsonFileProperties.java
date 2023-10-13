package com.hackathon.jump2digital.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
//@ConfigurationProperties(prefix = "custom.jsonFile")
@Getter
@Setter
public class JsonFileProperties {
    @Value("${custom.jsonFile.filePath}")
    private String filePath;

}

