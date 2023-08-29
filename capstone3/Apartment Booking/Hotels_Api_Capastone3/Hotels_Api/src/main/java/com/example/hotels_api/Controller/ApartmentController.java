package com.example.hotels_api.Controller;


import com.example.hotels_api.Api.ApiResponse;
import com.example.hotels_api.Dto.ApartmentDto;
import com.example.hotels_api.Model.Apartment;
import com.example.hotels_api.Service.ApartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;
    @GetMapping("/get")
    public ResponseEntity getAllApartment(){
        return ResponseEntity.status(200).body(apartmentService.getAllApartments());
    }

    @PostMapping("/add")
    public ResponseEntity addApartment(@RequestBody @Valid ApartmentDto apartment){
        apartmentService.addApartment(apartment);
        return ResponseEntity.status(200).body(new ApiResponse("Apartment Added Successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateApartment(@PathVariable Integer id, @RequestBody Apartment apartment) {
        apartmentService.updateApartment(id, apartment);
        return ResponseEntity.status(200).body("Apartment updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        apartmentService.deleteApartment(id);
        return ResponseEntity.status(200).body("Apartment deleted successfully");
    }


    @GetMapping("/priceLess/{price}")
    public ResponseEntity priceLess(@PathVariable Double price) {
        return ResponseEntity.status(200).body(apartmentService.lessPrice(price));
    }

    @GetMapping("/rangePrice/{price1}/{price2}")
    public ResponseEntity rangePrice(@PathVariable Double price1,@PathVariable Double price2) {
        return ResponseEntity.status(200).body(apartmentService.rangePrice(price1, price2));
    }

    @GetMapping("/hasKitchen")
    public ResponseEntity hasKitchen() {
        return ResponseEntity.status(200).body(apartmentService.hasKitchen());
    }

    @GetMapping("/manyRoom/{room}")
    public ResponseEntity manyRoom(@PathVariable Integer room) {
        return ResponseEntity.status(200).body(apartmentService.manyRoom(room));
    }



}