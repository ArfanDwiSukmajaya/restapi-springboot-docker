package com.example.backend.service;

import com.example.backend.model.Region;
import com.example.backend.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RegionService {

//    inject region repository
    private RegionRepository regionRepository;

    @Autowired

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

//    Get all data
    public List<Region> getAll(){
        return regionRepository.findAll();
    }

//    Get ByeId
    public Region getById(Long id){
        return regionRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "country not found"));
    }

//    Create Data
    public Region create(Region region){
        if(region.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Country Already Exist");
        }
        findByName(region.getName());
        return regionRepository.save(region);
    }

//    Update Data
    public Region update(Long id, Region region){
        region.setId(id);
        return regionRepository.save(region);
    }

//    Delete Data
    public Region delete(Long id){
        Region region = getById(id);
        regionRepository.delete(region);
        return region;
    }


//    Create validate if name of region is already exist when create region
    public void findByName(String name){
        if(regionRepository.findByName(name).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "region name is already exist");
        }
    }


}
