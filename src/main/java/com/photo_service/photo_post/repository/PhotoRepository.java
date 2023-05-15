package com.photo_service.photo_post.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.photo_service.photo_post.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer>{
    
    List<Photo> findByStatus(String status);
    
    List<Photo> findAll();

    Photo findByPhotoId(Integer photoId);

}
