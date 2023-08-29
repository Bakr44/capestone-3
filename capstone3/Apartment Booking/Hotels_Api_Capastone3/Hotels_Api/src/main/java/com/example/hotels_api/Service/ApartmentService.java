package com.example.hotels_api.Service;

import com.example.hotels_api.Api.ApiException;
import com.example.hotels_api.Dto.ApartmentDto;
import com.example.hotels_api.Model.Apartment;
import com.example.hotels_api.Model.Branch;
import com.example.hotels_api.Model.Customer;
import com.example.hotels_api.Repository.ApartmentRepository;
import com.example.hotels_api.Repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final BranchRepository branchRepository;

    public List<Apartment> getAllApartments(){
        return apartmentRepository.findAll();
    }

    public void addApartment(ApartmentDto apartmentDto){
        Branch branch = branchRepository.findBranchById(apartmentDto.getBranch_id());
        if (branch==null){
            throw new ApiException("Branch Id Not Found");
        }
        Apartment apartment=new Apartment(null, apartmentDto.getNumberOfRooms(), apartmentDto.getHasKitchen(),apartmentDto.getAvailable(), apartmentDto.getPricePerDay(), branch,null);
        apartmentRepository.save(apartment);
    }

    public void updateApartment(Integer id,Apartment apartment){
        Apartment apartment1 = apartmentRepository.findApartmentById(id);
        if (apartment1==null){
            throw new ApiException("Apartment with Id "+id+" not found");
        }
        apartment1.setNumberOfRooms(apartment.getNumberOfRooms());
        apartment1.setHasKitchen(apartment.getHasKitchen());
        apartment1.setAvailable(apartment.getAvailable());
        apartment1.setPricePerDay(apartment.getPricePerDay());
        apartmentRepository.save(apartment1);
    }


    public void deleteApartment(Integer id){
        Apartment apartment = apartmentRepository.findApartmentById(id);
        if (apartment==null){
            throw new ApiException("Apartment with Id "+id+" not found");
        }
        apartmentRepository.delete(apartment);
    }


    public List<Apartment> lessPrice(Double price){
        List<Apartment> apartmentsLessThan = apartmentRepository.lessPrice(price);
        if (apartmentsLessThan.isEmpty()){
            throw new ApiException("No Apartment with this price");
        }
        return apartmentsLessThan;
    }

    public List<Apartment> rangePrice(Double price1,Double price2){
        List<Apartment> apartmentsLessRange = apartmentRepository.rangePrice(price1, price2);
        if (apartmentsLessRange.isEmpty()){
            throw new ApiException("No Apartment with this price range");
        }
        return apartmentsLessRange;
    }

    public List<Apartment> hasKitchen(){
        List<Apartment> hasKitchen = apartmentRepository.hadKitchen();
        if (hasKitchen.isEmpty()){
            throw new ApiException("No Apartment has kitchen");
        }
        return hasKitchen;
    }

    public List<Apartment> manyRoom(Integer number){
        List<Apartment> manyRoom = apartmentRepository.manyRoom(number);
        if (manyRoom.isEmpty()){
            throw new ApiException("No Apartment with this number of Room");
        }
        return manyRoom;
    }






}
