package com.example.hotels_api.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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


    @ManyToOne
    @JoinColumn(name = "branch_id",referencedColumnName = "id")
    @JsonIgnore
    private Branch branch;

    @OneToMany(cascade = CascadeType.DETACH,mappedBy = "apartment")
    private Set<Order1> orders;

}
