package com.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dog")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dog_id")
    private int dogId;

    @Column(name = "dogname", length = 45, nullable = false)
    private String dogName;

    @Column(name = "dogsex", length = 11, nullable = false)
    private int sex; 
    
    @Column(name = "dogage", length = 45, nullable = false)
    private String age;

    @Column(name = "dogdetails", length = 255, nullable = false) // เปลี่ยนจาก dogname เป็น dogdetails
    private String details;

    @ManyToOne
    @JoinColumn(name = "breed_id")
    private dogbreed breed;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

   
     public Dog(int dogId, String dogName, int sex, String age, String details, dogbreed breed, Person owner) {
         this.dogId = dogId;
         this.dogName = dogName;
         this.sex = sex;
         this.age = age;
         this.details = details;
         this.breed = breed;
         this.owner = owner;
     }
    
    public Dog(String dogName, int sex, String age, String details, dogbreed breed, Person owner) {
        this.dogName = dogName;
        this.sex = sex;
        this.age = age;
        this.details = details;
        this.breed = breed;
        this.owner = owner;
    }
    
    public Dog() {
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public dogbreed getBreed() {
        return breed;
    }

    public void setBreed(dogbreed breed) {
        this.breed = breed;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}