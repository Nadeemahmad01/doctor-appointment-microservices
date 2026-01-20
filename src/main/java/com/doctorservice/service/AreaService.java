package com.doctorservice.service;

import com.doctorservice.Repository.AreaRepository;
import com.doctorservice.dto.AreaRequestDto;
import com.doctorservice.dto.AreaResponseDto;
import com.doctorservice.entity.Area;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService {

    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    // CREATE AREA
    public AreaResponseDto createArea(AreaRequestDto dto) {

        // 1️⃣ DTO → Entity
        Area area = new Area();
        area.setName(dto.getName());

        // 2️⃣ Save to DB
        Area savedArea = areaRepository.save(area);

        // 3️⃣ Entity → Response DTO
        AreaResponseDto response = new AreaResponseDto();
        response.setId(savedArea.getId());
        response.setName(savedArea.getName());

        return response;
    }

    // 🔹 GET ALL AREAS
    public List<AreaResponseDto> getAllAreas() {

        List<Area> areas = areaRepository.findAll();

        List<AreaResponseDto> responseList = new ArrayList<>();

        for (Area area : areas) {
            AreaResponseDto dto = new AreaResponseDto();
            dto.setId(area.getId());
            dto.setName(area.getName());
            responseList.add(dto);
        }

        return responseList;
    }

    // 🔹 GET AREA BY ID
    public AreaResponseDto getAreaById(Long id) {

        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area not found"));

        AreaResponseDto dto = new AreaResponseDto();
        dto.setId(area.getId());
        dto.setName(area.getName());

        return dto;
    }

    public AreaResponseDto updateArea(Long id, AreaRequestDto dto) {

        // 1️⃣ Find existing area
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area not found"));

        // 2️⃣ Update fields
        area.setName(dto.getName());

        // 3️⃣ Save updated entity
        Area updatedArea = areaRepository.save(area);

        // 4️⃣ Convert to response DTO
        AreaResponseDto response = new AreaResponseDto();
        response.setId(updatedArea.getId());
        response.setName(updatedArea.getName());

        return response;
    }


    public void deleteArea(Long id) {

        Area area=areaRepository.findById(id).orElseThrow(()->new RuntimeException("Area not found"));
        areaRepository.delete(area);
    }
}
