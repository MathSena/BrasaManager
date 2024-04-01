package org.mathsena.bmteams.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document
@Data
public class Team {
    @Id
    private String id;
    private String name;
    private String city;
    private String stadium;
    private String country;

}

