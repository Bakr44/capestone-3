package com.example.hotels_api.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;


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

    @ManyToOne
    @JoinColumn(name = "hotels_id",referencedColumnName = "id")
    @JsonIgnore
    private Hotels hotels;


    @OneToMany(cascade = CascadeType.DETACH,mappedBy = "branch")
    private Set<Apartment> apartments;


}

