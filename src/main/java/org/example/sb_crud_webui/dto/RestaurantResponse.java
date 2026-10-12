package org.example.sb_crud_webui.dto;

public record RestaurantResponse(Long id, String name, String location, double rating, String mainMenu, String category) {}
