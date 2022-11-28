package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Cirurgia;

public interface CirurgiaRepository extends JpaRepository<Cirurgia, Integer> {
    
}
