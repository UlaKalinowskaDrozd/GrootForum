package com.ula.grootforum.controllers;

import com.ula.grootforum.model.User;
import com.ula.grootforum.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Urszula Kalinowska-Drozd on 06.08.17.
 */

@Controller
public class SessionController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHomePage(){

        return "home";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String viewSignInPage(Model model){

        model.addAttribute("user", new User());
        return "signin";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogInPage(Model model){

        model.addAttribute("user", new User());
        return "login";

    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String logIn(Model model){
//
//        //TODO: stworzyć walidację i zapewnić BEZPIECZNE logowanie
//        return "redirect:/user/"; //+ user.getUserId();
//
//    }

    @RequestMapping(value="/signin", method = RequestMethod.POST)
    public String userRegistration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "/signin";
        }
        else{
            Long id = userService.saveUserAndGetUserId(user);
            return "redirect:/user/" + id;
        }
    }
}
