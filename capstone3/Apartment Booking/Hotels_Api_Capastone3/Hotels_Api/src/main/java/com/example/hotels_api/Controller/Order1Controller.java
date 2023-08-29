package com.example.hotels_api.Controller;

import com.example.hotels_api.Dto.Order1Dto;
import com.example.hotels_api.Model.Order1;
import com.example.hotels_api.Service.Order1Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class Order1Controller {

    private final Order1Service order1Service;

    @GetMapping("/get")
    public ResponseEntity getAllOrders() {
        return ResponseEntity.status(200).body(order1Service.getAllOrders());
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity getOrderById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(order1Service.getOrderById(id));
    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@RequestBody Order1 order) {
        order1Service.addOrder(order);
        return ResponseEntity.status(200).body("Order added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @RequestBody Order1 order) {
            order1Service.updateOrder(id, order);
            return ResponseEntity.status(200).body("Order updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
        order1Service.deleteOrder(id);
        return ResponseEntity.status(200).body("Order deleted successfully");
    }



    @PostMapping("/bocking/{Customer_id}/{Apartment_id}")
    public ResponseEntity bocking(@PathVariable Integer Customer_id,@PathVariable Integer Apartment_id,@RequestBody@Valid Order1 order1){
        order1Service.booking(Customer_id,Apartment_id,order1);
        return ResponseEntity.status(200).body("Booking Successfully");
    }

    @PutMapping("/complete/{orderId}")
    public ResponseEntity completeOrder( @PathVariable Integer orderId) {
        order1Service.approveOrder(orderId);
        return ResponseEntity.status(200).body("Order with ID " + orderId + " has been completed.");
    }


    @GetMapping("/getPending")
    public ResponseEntity getPending(){
        return ResponseEntity.status(200).body(order1Service.getAllPendingOrder());
    }

    @GetMapping("/getCompleted")
    public ResponseEntity getCompleted(){
        return ResponseEntity.status(200).body(order1Service.getAllCompletedOrder());
    }

    @PutMapping("/endOfDays/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Integer orderId) {
        order1Service.endOfDays(orderId);
        return ResponseEntity.status(200).body("the apartment now available");
    }


}
