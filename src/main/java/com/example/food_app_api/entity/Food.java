package com.example.food_app_api.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "foods")
public class Food {
    @Id
    private String id;
    private String name;
    private Double price;
    private Double star;
    private String description;
    private String thumbnail;
    private String username;
    private String comment;
    private String time;
}
