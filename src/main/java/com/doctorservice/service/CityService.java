package com.doctorservice.service;

import com.doctorservice.Repository.CityRepository;
import com.doctorservice.dto.CityRequestDto;
import com.doctorservice.dto.CityResponseDto;
import com.doctorservice.entity.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    // 1️⃣ CREATE CITY
    public CityResponseDto createCity(CityRequestDto dto) {

        City city = new City();
        city.setName(dto.getName());

        City savedCity = cityRepository.save(city);

        CityResponseDto response = new CityResponseDto();
        response.setId(savedCity.getId());
        response.setName(savedCity.getName());

        return response;
    }

    // 2️⃣ GET ALL CITIES
    public List<CityResponseDto> getAllCities() {

        List<City> cities = cityRepository.findAll();
        List<CityResponseDto> responseList = new ArrayList<>();

        for (City city : cities) {
            CityResponseDto dto = new CityResponseDto();
            dto.setId(city.getId());
            dto.setName(city.getName());
            responseList.add(dto);
        }

        return responseList;
    }

    // 3️⃣ GET CITY BY ID
    public CityResponseDto getCityById(Long id) {

        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));

        CityResponseDto dto = new CityResponseDto();
        dto.setId(city.getId());
        dto.setName(city.getName());

        return dto;
    }

    // 4️⃣ UPDATE CITY
    public CityResponseDto updateCity(Long id, CityRequestDto dto) {

        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));

        city.setName(dto.getName());

        City updatedCity = cityRepository.save(city);

        CityResponseDto response = new CityResponseDto();
        response.setId(updatedCity.getId());
        response.setName(updatedCity.getName());

        return response;
    }

    // 5️⃣ DELETE CITY
    public void deleteCity(Long id) {

        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));

        cityRepository.delete(city);
    }
}
