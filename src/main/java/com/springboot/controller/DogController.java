package com.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.Dog;
import com.springboot.model.Person;
import com.springboot.model.dogbreed;
import com.springboot.service.DogService;
import com.springboot.repository.PersonRepository;

@Controller
public class DogController {
    
    @Autowired
    private DogService dogService;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public ModelAndView dogmain() {
        List<dogbreed> breeds = dogService.getAllBreeds();  
        ModelAndView mav = new ModelAndView("maindog");
        mav.addObject("breeds", breeds);
        return mav;
    }

    @GetMapping("/showAllDogs")
    public ModelAndView showAllDogs() {
        List<Dog> dogs = dogService.getAllDogs();
        ModelAndView mav = new ModelAndView("listdog");
        mav.addObject("dogs", dogs);
        return mav;
    }
    
    @GetMapping("/adopt/{dogId}")
    public ModelAndView adoptDog(@PathVariable("dogId") int dogId) {
        Dog dog = dogService.getDogById(dogId);
        if (dog == null) {
            return new ModelAndView("redirect:/showAllDogs");
        }
        if (dog.getOwner() != null) {
            ModelAndView mav = new ModelAndView("errorpage");
            mav.addObject("message", "Sorry, this dog is already adopted.");
            return mav;
        }
        ModelAndView mav = new ModelAndView("adoptdog");
        mav.addObject("dog", dog);
        return mav;
    }

    @PostMapping("/adopt/save")
    public String saveAdoption(
            @RequestParam("dogId") int dogId,
            @RequestParam("idCard") String idCard,
            @RequestParam("fullName") String fullName,
            @RequestParam("address") String address,
            @RequestParam("mobile") String mobile,
            @RequestParam("email") String email,
            @RequestParam("gender") String gender) {
        
        Dog dog = dogService.getDogById(dogId);
        if (dog != null && dog.getOwner() == null) {

            Person owner = personRepository.findById(idCard).orElse(null);

            if (owner == null) {
                owner = new Person();
                owner.setPersonId(idCard);  
            }

            owner.setFullName(fullName);
            owner.setAddress(address);
            owner.setMobile(mobile);
            owner.setEmail(email);
            owner.setGender("male".equalsIgnoreCase(gender) ? 1 : 0);

            personRepository.save(owner);

            dog.setOwner(owner);
            dogService.saveDog(dog);
        }

        return "redirect:/";
    }
    @GetMapping("/dogsByBreed/{breedId}")
    public ModelAndView dogsByBreed(@PathVariable("breedId") int breedId) {
        List<Dog> dogs = dogService.getDogsByBreed(breedId);
        ModelAndView mav = new ModelAndView("listdog");
        mav.addObject("dogs", dogs);
        return mav;
    }
    

}
