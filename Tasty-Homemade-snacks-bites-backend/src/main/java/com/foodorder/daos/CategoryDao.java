package com.foodorder.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodorder.entities.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

}
