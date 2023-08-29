package com.example.hotels_api.Dto;

import com.example.hotels_api.Model.Apartment;
import com.example.hotels_api.Model.Customer;
import com.example.hotels_api.Model.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Setter @Getter
@AllArgsConstructor
public class Order1Dto {


    private Integer customer_id;

    private Integer apartment_id;


    @CreationTimestamp
    private LocalDate createdAt;

    @NotNull(message = "Number of days should not be empty")
    @Positive(message = "Number of days should be a positive number")
    @Column(nullable = false)
    private Integer numberOfDays;


    @Column(columnDefinition = "DATE")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

}
