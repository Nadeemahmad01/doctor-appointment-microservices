package com.doctorservice.Repository;

import com.doctorservice.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<TimeSlot,Long> {
}
