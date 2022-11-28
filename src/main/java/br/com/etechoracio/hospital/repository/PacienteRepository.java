package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    
}
