package com.photo_service.photo_post.repository;

import com.photo_service.photo_post.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAll();
        
}
