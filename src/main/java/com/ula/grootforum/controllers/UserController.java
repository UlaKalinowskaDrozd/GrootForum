package com.ula.grootforum.controllers;

import com.ula.grootforum.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Urszula Kalinowska-Drozd on 06.08.17.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String viewUserProfile(@PathVariable Long userId, Model model){
        model.addAttribute("user", userService.findUserById(userId));
        return "user";
    }

    @RequestMapping(value = "/UsersList", method = RequestMethod.GET)
    public String viewUsersProfilesList(Model model){

        model.addAttribute("usersList", userService.findAllUsers());
        return "usersList";
    }
}
