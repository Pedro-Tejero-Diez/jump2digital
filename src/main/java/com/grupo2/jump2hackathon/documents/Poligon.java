package com.grupo2.jump2hackathon.documents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown=true)
//@Document(collection = "poligons")
public class Poligon {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private ObjectId _id;
    private String type;
    private Geometry geometry;
    private Properties properties;
}
