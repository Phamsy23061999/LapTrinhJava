package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.CategoryEntity;

@Repository
public interface CategoryRepository  extends JpaRepository<CategoryEntity, Integer>{

}
