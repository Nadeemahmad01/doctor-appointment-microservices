package com.doctorservice.Repository;

import com.doctorservice.entity.DoctorAppointmentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorAppointmentScheduleRepository extends JpaRepository<DoctorAppointmentSchedule, Long> {
}
