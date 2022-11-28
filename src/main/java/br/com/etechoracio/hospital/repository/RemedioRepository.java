package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Remedio;

public interface RemedioRepository extends JpaRepository<Remedio, Integer> {
    
}
