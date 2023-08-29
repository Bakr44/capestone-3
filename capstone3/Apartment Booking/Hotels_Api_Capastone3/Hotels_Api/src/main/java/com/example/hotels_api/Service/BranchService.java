package com.example.hotels_api.Service;
import com.example.hotels_api.Api.ApiException;
import com.example.hotels_api.Dto.BranchDto;
import com.example.hotels_api.Model.Branch;
import com.example.hotels_api.Model.Hotels;
import com.example.hotels_api.Repository.BranchRepository;
import com.example.hotels_api.Repository.HotelsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final HotelsRepository hotelsRepository;
    public List<Branch> getAll(){
        return branchRepository.findAll();
    }

    public void addBranch(BranchDto branch){
        Hotels hotels = hotelsRepository.findHotelById(branch.getHotels_id());
        if (hotels==null){
            throw new ApiException("Hotel not found");
        }
        Branch branch1 = new Branch(null,branch.getName(), branch.getNeighborhood(), branch.getStreet(),branch.getCity(), branch.getPhone_number(), hotels,null);
        branchRepository.save(branch1);
    }


    public void updateBranch(Integer id,Branch branch){
        Branch branch1 = branchRepository.findBranchById(id);
        if (branch1==null){
            throw new ApiException("Branch with Id " +id+ " not found");
        }
        branch1.setName(branch.getName());
        branch1.setNeighborhood(branch.getNeighborhood());
        branch1.setStreet(branch.getStreet());
        branch1.setPhone_number(branch.getPhone_number());
        branchRepository.save(branch1);
    }


    public void deleteBranch(Integer id){
        Branch branch = branchRepository.findBranchById(id);
        if (branch==null){
            throw new ApiException("Branch with Id " +id+ " not found");
        }
        branchRepository.delete(branch);
    }


    public List<Branch> findByCity(String city){
        List<Branch>  citys = branchRepository.findBranchByCity(city);
        if (citys.isEmpty()){
            throw new ApiException("invalid city");
        }
        return branchRepository.findBranchByCity(city);
    }



}