package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Enfermeiro;

public interface EnfermeiroRepository extends JpaRepository<Enfermeiro, Integer> {
    
}
