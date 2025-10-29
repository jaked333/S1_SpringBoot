package com.springboot.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "dogbreed")
public class dogbreed {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breed_id")
    private int breedId;

    @Column(nullable = false, name = "breed_name")
    private String breedName;

    @OneToMany(mappedBy = "breed", cascade = CascadeType.ALL)
    private List<Dog> dogs;

    public dogbreed(String breedName) {
        this.breedName = breedName;
    }

    public dogbreed(int breedId, String breedName) {
        this.breedId = breedId;
        this.breedName = breedName;
    }

    public dogbreed() {
    }

    public int getBreedId() {
        return breedId;
    }

    public void setBreedId(int breedId) {
        this.breedId = breedId;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}