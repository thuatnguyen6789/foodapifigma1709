package com.example.food_app_api.controller;

import com.example.food_app_api.entity.Food;
import com.example.food_app_api.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/foods")
@CrossOrigin("*")
public class FoodApi {
    @Autowired
    private FoodRepository foodRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Food addFood(@RequestBody Food food) {
        foodRepository.save(food);
        return food;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public boolean deleteById(@PathVariable String id){
        Optional<Food> optionalFood = foodRepository.findById(String.valueOf(id));
        if(optionalFood.isPresent()){
            Food food = optionalFood.get();
            foodRepository.delete(food);
        }
        return false;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public Food updateById(@RequestBody Food updateFood, @PathVariable String id){
        Optional<Food> optionalFood = foodRepository.findById(String.valueOf(id));
        if(optionalFood.isPresent()){
            Food existingFood = optionalFood.get();
            existingFood.setName(updateFood.getName());
            existingFood.setPrice(updateFood.getPrice());
            existingFood.setStar(updateFood.getStar());
            existingFood.setDescription(updateFood.getDescription());
            existingFood.setThumbnail(updateFood.getThumbnail());
            existingFood.setUsername(updateFood.getUsername());
            existingFood.setComment(updateFood.getComment());
            existingFood.setTime(updateFood.getTime());
        }
        return null;
    }
}

