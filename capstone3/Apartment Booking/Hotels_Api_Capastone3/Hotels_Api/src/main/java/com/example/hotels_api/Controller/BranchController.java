package com.example.hotels_api.Controller;

import com.example.hotels_api.Api.ApiResponse;
import com.example.hotels_api.Dto.BranchDto;
import com.example.hotels_api.Model.Branch;
import com.example.hotels_api.Service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/branch")
public class BranchController {

    private final BranchService branchService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(branchService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid BranchDto branch){
        branchService.addBranch(branch);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Branch branch){
        branchService.updateBranch(id,branch);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        branchService.deleteBranch(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }

    @GetMapping("/findCity/{city}")
    public ResponseEntity findCity(@PathVariable String city){
        return ResponseEntity.status(200).body(branchService.findByCity(city));
    }




}