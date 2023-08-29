package com.example.hotels_api.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchDto {

    private Integer hotels_id;

    @NotEmpty(message = "can not be empty !")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "can not be empty !")
    @Column(columnDefinition = "varchar(20) not null")
    private String neighborhood;

    @NotEmpty(message = "can not be empty !")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;

    @NotEmpty(message = "can not be empty !")
    @Column(columnDefinition = "varchar(20) not null")
    private String city;


    @NotEmpty(message = "can not be empty !")
    @Size(min = 10,max = 10,message = "must be 10 digits")
    @Column(columnDefinition = "varchar(10) not null")
    private String phone_number;
}