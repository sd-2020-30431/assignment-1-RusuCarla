package com.assignment.business_layer.controller;

import com.assignment.dto.*;
import com.assignment.services_layer.entity.Groceries;
import com.assignment.services_layer.services.GroceriesService;
import com.assignment.services_layer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/groceries")
public class GroceriesController {

    @Autowired
    GroceriesService groceriesService;

    @PostMapping(value = "/addGrocery")
    public ResponseEntity<StringObj> addGrocery(@RequestBody GroceriesDto groceriesDto, @RequestHeader("userId") String id) {
        //valid

        groceriesService.addGroceries(groceriesDto, Integer.parseInt(id));
        return new ResponseEntity<>(new StringObj("SUCCESS: ADDED GROCERY"), HttpStatus.OK);
    }

    @PostMapping(value = "/addConsumptionDate")
    public ResponseEntity addConsumptionDate(@RequestBody ConsumptionDto consumptionDto, @RequestHeader("userId") String id) {
        //valid

        groceriesService.addConsumptionDate(consumptionDto, Integer.parseInt(id));
        return new ResponseEntity( HttpStatus.OK);
    }

    @GetMapping(value = "/getGroceries")
    public ResponseEntity<ArrayList<GroceriesDto>> getCustomers(@RequestHeader("userId") String id) {
        ArrayList<GroceriesDto> groceriesDtos = groceriesService.getGroceries(Integer.parseInt(id));
        return new ResponseEntity<>(groceriesDtos, HttpStatus.OK);
    }
}