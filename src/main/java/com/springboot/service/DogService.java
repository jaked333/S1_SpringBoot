package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.springboot.model.Dog;
import com.springboot.model.dogbreed;
import com.springboot.repository.DogRepository;
import com.springboot.repository.DogBreedRepository;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepo;

    @Autowired
    private DogBreedRepository breedRepo;

    public List<Dog> getAllDogs() {
        return dogRepo.findAll();
    }

    public List<dogbreed> getAllBreeds() {
        return breedRepo.findAll();
    }

    public List<Dog> getDogsByName(String name) {
        return dogRepo.findByDogName(name);
    }

    public Dog saveDog(Dog dog) {
        return dogRepo.save(dog);
    }

    public Dog getDogById(int id) {
        return dogRepo.findById(id).orElse(null);
    }

    public void deleteDog(int id) {
        dogRepo.deleteById(id);
    }

    public List<Dog> getDogsByBreed(int breedId) {
        return dogRepo.findByBreed_BreedIdAndOwnerIsNull(breedId);
    }
}
