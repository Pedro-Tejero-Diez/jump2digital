package com.grupo2.jump2hackathon.documents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Document(collection = "barrio")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Barrio {
    @MongoId
    @JsonIgnore
    private ObjectId _id;
    private String codiDistricte;
    private String nomDistricte;
    private String codiBarri;
    private String nomBarri;
    @Field(name = "nAltres")
    private Integer nAltres;
    @Field(name = "nAutomocio")
    private Integer nAutomocio;
    @Field(name = "nEquipamentPersonal")
    private Integer nEquipamentPersonal;
    @Field(name = "nLocalBuit")
    private Integer nLocalBuit;
    @Field(name = "nOciCultura")
    private Integer nOciCultura;
    @Field(name = "nParamentLlar")
    private Integer nParamentLlar;
    @Field(name = "nQuotidiaAlimentari")
    private Integer nQuotidiaAlimentari;
    @Field(name = "nQuotidiaNoAlimentari")
    private Integer nQuotidiaNoAlimentari;
    @Field(name = "nServeis")
    private Integer nServeis;
    private Integer preuMitja;
    private long Anio;
    private Integer preuM2;
    private Poligon poligon;
}
