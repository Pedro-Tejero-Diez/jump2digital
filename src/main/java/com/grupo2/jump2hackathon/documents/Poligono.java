package com.grupo2.jump2hackathon.documents;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "poligons")
public class Poligono {
    private String type;
    private Geometry geometry;
    private Properties properties;
}
