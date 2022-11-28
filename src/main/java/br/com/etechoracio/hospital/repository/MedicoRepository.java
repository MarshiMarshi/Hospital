package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    
}
