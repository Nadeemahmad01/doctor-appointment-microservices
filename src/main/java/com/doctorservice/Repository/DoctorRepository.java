package com.doctorservice.Repository;

import com.doctorservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    // custom query methods (later use)
    List<Doctor> findBySpecialization(String specialization);

}
