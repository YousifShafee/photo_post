package com.photo_service.photo_post.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.photo_service.photo_post.model.Category;
import com.photo_service.photo_post.model.Photo;
import com.photo_service.photo_post.repository.CategoryRepository;
import com.photo_service.photo_post.repository.PhotoRepository;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private PhotoRepository photoRepo;

    @Autowired
    private CategoryRepository categoryRepo;
     
    @RequestMapping("upload_photo")
    public String displayUploadPage(Model model, @RequestParam(value = "message", required = false) String message) {
        List<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("message", message);
        model.addAttribute("photo", new Photo());
        return "upload_photo.html";
    }

    @PostMapping("save_photo")
    public String savePhoto(@ModelAttribute("photo") Photo photo, @RequestParam("file") MultipartFile file) throws IOException {
        photo.setName(file.getOriginalFilename());
        photo.setPhoto(file.getBytes());
        photoRepo.save(photo);
        return "redirect:/user/upload_photo?message=Photo uploaded successfully";
    }
}
