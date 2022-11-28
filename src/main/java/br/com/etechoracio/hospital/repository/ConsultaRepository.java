package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    
}
