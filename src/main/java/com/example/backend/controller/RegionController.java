package com.example.backend.controller;

import com.example.backend.model.Region;
import com.example.backend.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/region")
public class RegionController {
    final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

//    Get All Data
    @GetMapping
    public ResponseEntity<List<Region>> getAll(){
        return new ResponseEntity<>(regionService.getAll(), HttpStatus.OK);
    }

//    Get ById
    @GetMapping("/{id}")
    public ResponseEntity<Region> getById(@PathVariable Long id){
        return new ResponseEntity<>(regionService.getById(id), HttpStatus.OK);
    }


//    Add Data
    @PostMapping
    public ResponseEntity<Region> create(@RequestBody Region region){
        return new ResponseEntity<>(regionService.create(region), HttpStatus.CREATED);
    }
// Update Data
    @PutMapping("/{id}")
    public ResponseEntity<Region> update(@PathVariable Long id, @RequestBody Region region) {
        return new ResponseEntity<>(regionService.update(id, region), HttpStatus.OK);
    }

//    Delete Data
    @DeleteMapping("/{id}")
    public ResponseEntity<Region> delete(@PathVariable Long id){
        return new ResponseEntity<>(regionService.delete(id), HttpStatus.OK);
    }
 }
