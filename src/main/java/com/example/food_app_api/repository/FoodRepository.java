package com.example.food_app_api.repository;

import com.example.food_app_api.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, String> {
}
