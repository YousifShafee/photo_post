package com.photo_service.photo_post.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.photo_service.photo_post.model.Person;
import com.photo_service.photo_post.repository.PersonRepository;

@Controller
public class GreetController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("greet")
    public String displayGreetPage(Model model,Authentication authentication, HttpSession session) {
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", person.getFirstName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        session.setAttribute("loggedInPerson", person);
        return "greet.html";
    }
}
