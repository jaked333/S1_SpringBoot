package com.springboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {
    List<Dog> findByDogName(String dogName);

    List<Dog> findByBreed_BreedIdAndOwnerIsNull(int breedId);
}
