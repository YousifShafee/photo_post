package com.photo_service.photo_post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.photo_service.photo_post.model.Photo;
import com.photo_service.photo_post.repository.PhotoRepository;

@Controller
@RequestMapping("photo")
public class PhotoController {
    
    @Autowired
    private PhotoRepository photoRepo;

    @GetMapping("{id}")
    public ResponseEntity<byte []> displayImage(@PathVariable String id) {
        Photo photo = photoRepo.findByPhotoId(Integer.parseInt(id));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(photo.getPhoto(), headers, HttpStatus.OK);
    }

}