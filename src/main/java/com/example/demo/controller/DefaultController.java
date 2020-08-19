package com.example.demo.controller;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.User;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class DefaultController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping( value = "/create-product")
    public String admin(Model model) {
        ProductEntity product = new ProductEntity();
        model.addAttribute("product", product);
        return "create";
    }
    @PostMapping(value = "/create-product" )
    public String saveProduct(@Valid @ModelAttribute("product") ProductEntity product, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "create";
        }

        productService.createProduct(product);
        return "redirect:/home";
    }



    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/error")
    public String error() {
        return "/error/403";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "/login";
//    }
//

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }



    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("register");

        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView adminhome(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        modelAndView.addObject("username", "Welcome " + user.getUsername() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

}
