package com.example.hotels_api.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApartmentDto {

    private Integer branch_id;

    @NotNull
    @Positive(message = "Number of rooms should be numbers")
    @Column(columnDefinition = "int",nullable = false)
    private Integer numberOfRooms;

    @Column(columnDefinition = "bit not null")
    private Boolean hasKitchen=false;


    @Column(columnDefinition = "bit not null")
    private Boolean available=true;


    @NotNull
    @Column(columnDefinition = "int not null")
    private Double pricePerDay;
}