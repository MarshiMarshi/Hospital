package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Integer> {
    
}
