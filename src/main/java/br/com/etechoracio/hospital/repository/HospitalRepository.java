package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    
}
