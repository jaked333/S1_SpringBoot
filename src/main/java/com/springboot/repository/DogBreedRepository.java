package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.dogbreed;

@Repository
public interface DogBreedRepository extends JpaRepository<dogbreed, Integer> {
    
}
