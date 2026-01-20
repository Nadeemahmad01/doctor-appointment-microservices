package com.doctorservice.controller;

import com.doctorservice.dto.CityRequestDto;
import com.doctorservice.dto.CityResponseDto;
import com.doctorservice.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    // 1️⃣ CREATE CITY
    @PostMapping
    public CityResponseDto createCity(@RequestBody CityRequestDto dto) {
        return cityService.createCity(dto);
    }

    // 2️⃣ GET ALL CITIES
    @GetMapping
    public List<CityResponseDto> getAllCities() {
        return cityService.getAllCities();
    }

    // 3️⃣ GET CITY BY ID
    @GetMapping("/{id}")
    public CityResponseDto getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    // 4️⃣ UPDATE CITY
    @PutMapping("/{id}")
    public CityResponseDto updateCity(
            @PathVariable Long id,
            @RequestBody CityRequestDto dto) {

        return cityService.updateCity(id, dto);
    }

    // 5️⃣ DELETE CITY
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}
