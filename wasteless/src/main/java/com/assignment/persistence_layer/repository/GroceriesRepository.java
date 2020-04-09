package com.assignment.persistence_layer.repository;

import com.assignment.services_layer.entity.Groceries;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroceriesRepository extends JpaRepository<Groceries,Integer> {

    Groceries findByName(String name);
}
