package com.example.atletiek_fribourg.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    private String datum;
    private String opwarming;
    private String gevoelOpwarming;
    private String specifiekOnderdeel;
    private String specifiekOnderdeelUitleg;
    private String gevoelSpecifiekOnderdeel;
//    private String trainer;
//    private String feedback;

}