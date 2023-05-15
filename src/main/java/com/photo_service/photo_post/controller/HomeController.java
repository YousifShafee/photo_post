package com.photo_service.photo_post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.photo_service.photo_post.constants.PhotoPostConstants;
import com.photo_service.photo_post.model.Photo;
import com.photo_service.photo_post.repository.PhotoRepository;

@Controller
public class HomeController {

    @Autowired
    private PhotoRepository photoRepo;

    @RequestMapping(value={"", "/", "home"})
    public ModelAndView displayHomePage() {
        ModelAndView modelAndView = new ModelAndView("home.html");
        List<Photo> photos = photoRepo.findByStatus(PhotoPostConstants.ACCEPT_STATUS);
        modelAndView.addObject("photos", photos);
        return modelAndView;
    }

}
