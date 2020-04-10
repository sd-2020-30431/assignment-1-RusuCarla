package com.assignment.services_layer.services;

import com.assignment.dto.*;
import com.assignment.services_layer.*;
import com.assignment.persistence_layer.repository.LoginRepository;
import com.assignment.persistence_layer.repository.*;
import com.assignment.services_layer.entity.Groceries;
import com.assignment.services_layer.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;


@Service
public class UserService {
    @Autowired
    GroceriesRepository groceriesRepository;
    @Autowired
    LoginRepository loginRepository;


    @Transactional
    public int register(LoginDto loginDto) {
        if (loginRepository.findByUsername(loginDto.getUsername()) != null)
            return -1;

        Login login = new Login();
        login.setUsername(loginDto.getUsername());
        login.setPassword(loginDto.getPassword());
        loginRepository.save(login);
        return 0;
    }

    public Integer login(LoginDto loginDto) {
        Login login = loginRepository.findByUsername(loginDto.getUsername());
        if (login != null)
            if (login.getPassword().equals(loginDto.getPassword()))
                return login.getId();
        return null;
    }

    public void logout(Integer id) {
    }

    public LoginDto findById(int id) {
        Login login = loginRepository.findById(id);
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(login.getUsername());
        loginDto.setPassword(login.getPassword());
        return loginDto;
    }
}
