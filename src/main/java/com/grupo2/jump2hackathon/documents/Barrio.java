package com.grupo2.jump2hackathon.documents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("nAltres")
    private int nAltres;
    @JsonProperty("nAutomocio")
    private int nAutomocio;
    @JsonProperty("nEquipamentPersonal")
    private int nEquipamentPersonal;
    @JsonProperty("nLocalBuit")
    private int nLocalBuit;
    @JsonProperty("nOciCultura")
    private int nOciCultura;
    @JsonProperty("nParamentLlar")
    private int nParamentLlar;
    @JsonProperty("nQuotidiaAlimentari")
    private int nQuotidiaAlimentari;
    @JsonProperty("nQuotidiaNoAlimentari")
    private int nQuotidiaNoAlimentari;
    @JsonProperty("nServeis")
    private int nServeis;
    private int preuMitja;
    private long Anio;
    private int preuM2;
    private Poligon poligon;
}
