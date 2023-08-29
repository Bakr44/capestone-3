package com.example.hotels_api.Controller;



import com.example.hotels_api.Api.ApiResponse;
import com.example.hotels_api.Model.Hotels;
import com.example.hotels_api.Service.HotelsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotels")
public class HotelsController {

    private final HotelsService hotelsService;



    @GetMapping("/get")
    public ResponseEntity getAllHotel(){
        return ResponseEntity.status(200).body(hotelsService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity addHotel(@RequestBody @Valid Hotels hotels){
        hotelsService.addHotels(hotels);
        return ResponseEntity.status(200).body(new ApiResponse("Hotel Added"));
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity updateHotel(@PathVariable Integer id, @RequestBody @Valid Hotels hotels){
        hotelsService.updateHotels(id,hotels);
        return ResponseEntity.status(200).body(new ApiResponse("Hotel Updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteHotel(@PathVariable Integer id){
        hotelsService.deleteHotels(id);
        return ResponseEntity.status(200).body(new ApiResponse("Hotel Deleted"));
    }

}
