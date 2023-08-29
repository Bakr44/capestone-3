package com.example.hotels_api.Service;
import com.example.hotels_api.Api.ApiException;
import com.example.hotels_api.Model.Hotels;
import com.example.hotels_api.Repository.HotelsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelsService {

    private final HotelsRepository hotelsRepository;



    public List<Hotels> getAll(){
        return hotelsRepository.findAll();
    }

    public void addHotels(Hotels hotels){
        hotelsRepository.save(hotels);
    }

    public void updateHotels(Integer id,Hotels hotels){
        Hotels hotels1= hotelsRepository.findHotelById(id);
        if (hotels1==null){
            throw new ApiException("Hotel with ID " + id + " not found");
        }
        hotels1.setName(hotels.getName());
        hotelsRepository.save(hotels1);
    }


    public void deleteHotels(Integer id){
        Hotels hotels1= hotelsRepository.findHotelById(id);
        if (hotels1==null){
            throw new ApiException("Hotel with ID " + id + " not found");
        }
        hotelsRepository.delete(hotels1);
    }



}