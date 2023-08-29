package com.example.hotels_api.Repository;

import com.example.hotels_api.Model.Order1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Order1Repository extends JpaRepository<Order1,Integer> {

    Order1 findOrder1ById(Integer id);

    List<Order1> findOrdersByCustomerId(Integer id);


    @Query("select c from Order1 c where c.status='PENDING'")
    List<Order1> pendingOrders();

    @Query("select o from Order1 o where o.status='COMPLETED'")
    List<Order1> findOrder1Completed();
}
