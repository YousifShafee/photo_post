package com.photo_service.photo_post.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.photo_service.photo_post.constants.PhotoPostConstants;
import com.photo_service.photo_post.model.Photo;
import com.photo_service.photo_post.repository.PhotoRepository;


@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private PhotoRepository photoRepo;
    
    @RequestMapping("review")
    public String displayReviewPage(Model model, @RequestParam(value = "message", required = false) String message) {
        List<Photo> photos = photoRepo.findByStatus(PhotoPostConstants.PENDING_STATUS);
        model.addAttribute("photos", photos);
        model.addAttribute("message", message);
        return "review.html";
    }

    @RequestMapping("set_status")
    public String changePhotoStatus(Model model, @RequestParam("status") String status, @RequestParam("photo") Photo photo) throws IOException {
        photo.setStatus(status);
        photoRepo.save(photo);
        return "redirect:/admin/review?message=Photo " + status.toLowerCase() + " successfully";
    }

}
