package com.assignment.business_layer.controller;

import com.assignment.dto.*;
import com.assignment.services_layer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<StringObj> register(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto);
        switch (userService.register(loginDto)) {
            case 0:
                return new ResponseEntity<>(new StringObj("SUCCESS : USER REGISTERED"), HttpStatus.OK);
            case -1:
                return new ResponseEntity<>(new StringObj("ERROR: DUPLICATE USERNAME"), HttpStatus.CONFLICT);
            default:
                return new ResponseEntity<>(new StringObj("ERROR: UNKNOWN"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Integer> login(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto);
        Integer id = userService.login(loginDto);
        if (id == null)
            return new ResponseEntity<>(id, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<String> logout(@RequestHeader("id") Integer id) {
        userService.logout(id);
        return new ResponseEntity<>("SUCCESS: LOGGED OUT", HttpStatus.OK);
    }
}
