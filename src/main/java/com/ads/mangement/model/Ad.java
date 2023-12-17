package com.ads.mangement.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private AdCategory category;
    private String description;
    private Double price;
    private String picture;
    private String location;
    private String phoneNumber;
    private boolean stillAvailable;
    private Date dateCreated;
    private String createdBy;
}
