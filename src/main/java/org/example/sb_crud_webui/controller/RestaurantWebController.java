package org.example.sb_crud_webui.controller;

import org.example.sb_crud_webui.dto.RestaurantRequest;
import org.example.sb_crud_webui.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestaurantWebController {
    private final RestaurantService restaurantService;

    public RestaurantWebController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public String list(Model model){
        model.addAttribute("restaurants" , restaurantService.findAll());
        return "restaurants/list";
    }

    @GetMapping("/restaurants/new")
    public String form(){
        return "restaurants/form";
    }

    @PostMapping("/restaurants")
    public String create(@ModelAttribute RestaurantRequest request){
        restaurantService.create(request);
        return "redirect:/restaurants";
    }
}
