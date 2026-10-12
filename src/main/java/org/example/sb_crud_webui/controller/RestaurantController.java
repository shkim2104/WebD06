package org.example.sb_crud_webui.controller;

import org.example.sb_crud_webui.dto.*;
import org.example.sb_crud_webui.service.RestaurantService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @PostMapping public ResponseEntity<RestaurantResponse> create(@RequestBody RestaurantRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.create(request));
    }
    @GetMapping public List<RestaurantResponse> findAll(@RequestParam(required = false) String category) {
        return category == null ? restaurantService.findAll() : restaurantService.findByCategory(category);
    }
    @GetMapping("/{id}") public RestaurantResponse findById(@PathVariable Long id) {
        return restaurantService.findById(id);
    }
    @PutMapping("/{id}") public RestaurantResponse update(@PathVariable Long id,@RequestBody RestaurantRequest request) {
        return restaurantService.update(id,request);
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        restaurantService.delete(id); return ResponseEntity.noContent().build();
    }
}
