package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Exame;

public interface ExameRepository extends JpaRepository<Exame, Integer> {
    
}
