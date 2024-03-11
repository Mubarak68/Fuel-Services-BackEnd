package com.fuelservices.Fuel.and.Services.App.entity;

import javax.persistence.*;

@Entity
@Table(name = "request_entity")
public class RequestEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
