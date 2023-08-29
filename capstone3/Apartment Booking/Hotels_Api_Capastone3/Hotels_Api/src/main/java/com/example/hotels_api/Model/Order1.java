package com.example.hotels_api.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotNull(message = "Date should be not empty")
//    @Column(columnDefinition = " DATE not null")
//    private LocalDate date;


    @CreationTimestamp
    private LocalDate createdAt=LocalDate.now();

    @NotNull(message = "Number of days should not be empty")
    @Positive(message = "Number of days should be a positive number")
    @Column(nullable = false)
    private Integer numberOfDays;

//    @NotNull(message = "End date should not be empty")
    @Column(columnDefinition = "DATE")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    @JsonIgnore
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "apartment_id",referencedColumnName = "id")
    @JsonIgnore
    private Apartment apartment;

}
