package com.example.hotels_api.Controller;

import com.example.hotels_api.Api.ApiResponse;
import com.example.hotels_api.Model.Customer;
import com.example.hotels_api.Service.CustomerService;
import com.example.hotels_api.Service.Order1Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final Order1Service order1Service;

    @GetMapping("/get")
    public ResponseEntity getAllCustomers(){
        return ResponseEntity.status(200).body(customerService.getAllCustomer());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomers(@RequestBody @Valid Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("Customer Added Successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomers(@PathVariable Integer id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Customer updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Teacher deleted successfully");
    }

    @GetMapping("/get-customer-orders/{customerId}")
    public ResponseEntity getOrdersForCustomer(@PathVariable Integer customerId) {
        return ResponseEntity.status(200).body(order1Service.getOrdersByCustomerId(customerId));
    }


}
