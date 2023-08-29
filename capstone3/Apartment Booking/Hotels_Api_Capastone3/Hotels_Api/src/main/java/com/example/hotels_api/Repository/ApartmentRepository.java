package com.example.hotels_api.Repository;

import com.example.hotels_api.Model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Integer> {
    Apartment findApartmentById(Integer id);


    @Query("select c from Apartment c where c.pricePerDay<?1 and c.available=true ")
    List<Apartment> lessPrice(Double price);

    @Query("select c from Apartment c where c.pricePerDay>=?1 and c.pricePerDay<=?2 and  c.available=true")
    List<Apartment> rangePrice(Double price1,Double price2);

    @Query("select c from Apartment c where c.hasKitchen=true and c.available=true")
    List<Apartment> hadKitchen();

    @Query("select c from Apartment c where c.numberOfRooms=?1 and c.available=true")
    List<Apartment> manyRoom(Integer room);


}
