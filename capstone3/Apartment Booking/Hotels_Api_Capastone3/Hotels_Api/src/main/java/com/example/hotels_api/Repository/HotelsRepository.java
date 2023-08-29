package com.example.hotels_api.Repository;

import com.example.hotels_api.Model.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels,Integer> {

    Hotels findHotelById(Integer id);
}
