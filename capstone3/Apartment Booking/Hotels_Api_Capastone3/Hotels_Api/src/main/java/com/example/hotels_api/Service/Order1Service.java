package com.example.hotels_api.Service;

import com.example.hotels_api.Api.ApiException;
import com.example.hotels_api.Dto.Order1Dto;
import com.example.hotels_api.Model.Apartment;
import com.example.hotels_api.Model.Customer;
import com.example.hotels_api.Model.Order1;
import com.example.hotels_api.Model.OrderStatus;
import com.example.hotels_api.Repository.ApartmentRepository;
import com.example.hotels_api.Repository.CustomerRepository;
import com.example.hotels_api.Repository.Order1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Order1Service {

    private final Order1Repository order1Repository;
    private final CustomerRepository customerRepository;
    private final ApartmentRepository apartmentRepository;

    public List<Order1> getAllOrders() {
        return order1Repository.findAll();
    }

    public Order1 getOrderById(Integer id) {
        Order1 order1=order1Repository.findOrder1ById(id);
        if (order1 == null) {
            throw new ApiException("ID Not Found");
        }
        return order1Repository.findOrder1ById(id);
    }

    public void addOrder(Order1 order) {
        LocalDate endDate = order.getCreatedAt().plusDays(order.getNumberOfDays());
        order.setEndDate(endDate);
        // Set the initial status to PENDING
        order.setStatus(OrderStatus.PENDING);
        order1Repository.save(order);
    }

    public void updateOrder(Integer id, Order1 order) {
        Order1 order1=order1Repository.findOrder1ById(id);
        if (order1==null) {
            throw new ApiException("Order with ID " + id + " not found");
        }
        order.setNumberOfDays(order1.getNumberOfDays());
        order1Repository.save(order);
    }

    public void deleteOrder(Integer id) {
        order1Repository.deleteById(id);
    }



    public List<Order1> getOrdersByCustomerId(Integer customerId) {
        return order1Repository.findOrdersByCustomerId(customerId);
    }


    public void endOfDays(Integer orderId) {
        Order1 order = order1Repository.findOrder1ById(orderId);
        if (order == null) {
            throw new ApiException("Order with ID " + orderId + " not found");
        }
        if (order.getStatus().equals(OrderStatus.RESERVATION_IS_OVER)){
            throw new ApiException("already over !");
        }
        order.setStatus(OrderStatus.RESERVATION_IS_OVER);
        Apartment apartment = apartmentRepository.findApartmentById(order.getApartment().getId());
        apartment.setAvailable(true);
        order1Repository.save(order);
    }


    public void booking(Integer customerId,Integer apartmentId,Order1 order) {
        Customer customer = customerRepository.findCustomerById(customerId);
        Apartment apartment = apartmentRepository.findApartmentById(apartmentId);
        if (customer == null) {
            throw new ApiException("wrong customer id");
        }
        if (apartment == null) {
            throw new ApiException("wrong apartment id");
        }
        if (apartment.getAvailable() == false) {
            throw new ApiException("the apartment not avalible");
        }
        if (customer.getBalance() < apartment.getPricePerDay() * order.getNumberOfDays()) {
            throw new ApiException("you do not have much money !");
        }
        LocalDate endDate = order.getCreatedAt().plusDays(order.getNumberOfDays());
        order.setEndDate(endDate);
        order.setStatus(OrderStatus.PENDING);
        // Set the initial status to PENDING
        apartment.setAvailable(false);

        customer.setBalance(customer.getBalance()-(apartment.getPricePerDay() * order.getNumberOfDays()));

        order.setCustomer(customer);
        order.setApartment(apartment);
        order1Repository.save(order);

    }


    public void approveOrder(Integer orderId) {
        Order1 order = order1Repository.findOrder1ById(orderId);
        if (order == null) {
            throw new ApiException("Order with ID " + orderId + " not found");
        }
        if (order.getCustomer() == null) {
            throw new ApiException("Order with ID " + orderId + " does not have an associated customer");
        }

        // Implement logic to update order status to "Canceled" and perform any other necessary actions.
        order.setStatus(OrderStatus.COMPLETED);
        order1Repository.save(order);
    }




    public List<Order1> getAllPendingOrder(){
        return order1Repository.pendingOrders();
    }

    public List<Order1> getAllCompletedOrder(){
        return order1Repository.findOrder1Completed();
    }




}
