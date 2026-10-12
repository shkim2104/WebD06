package org.example.sb_crud_webui.repository;

import org.example.sb_crud_webui.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);
    List<Restaurant> findAll();
    Optional<Restaurant> findById(Long id);
    Restaurant update(Restaurant restaurant);
    void deleteById(Long id);
}
