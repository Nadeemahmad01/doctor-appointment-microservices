package com.doctorservice.controller;

import com.doctorservice.dto.AreaRequestDto;
import com.doctorservice.dto.AreaResponseDto;
import com.doctorservice.service.AreaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/areas")
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    // CREATE AREA API
    @PostMapping
    public AreaResponseDto createArea(
            @RequestBody AreaRequestDto dto) {

        return areaService.createArea(dto);
    }

    // 🔹 GET ALL
    @GetMapping("/all")
    public List<AreaResponseDto> getAllAreas() {
        return areaService.getAllAreas();
    }

    // 🔹 GET BY ID
    @GetMapping("/{id}")
    public AreaResponseDto getAreaById(@PathVariable Long id) {
        return areaService.getAreaById(id);
    }
}
