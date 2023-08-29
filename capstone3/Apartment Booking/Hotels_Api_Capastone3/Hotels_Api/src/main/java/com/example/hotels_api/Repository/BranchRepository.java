package com.example.hotels_api.Repository;

import com.example.hotels_api.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {
    Branch findBranchById(Integer id);

    List<Branch> findBranchByCity(String city);


}
