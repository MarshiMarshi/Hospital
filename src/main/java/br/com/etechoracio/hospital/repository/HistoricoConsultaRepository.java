package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.HistoricoConsulta;

public interface HistoricoConsultaRepository extends JpaRepository<HistoricoConsulta, Integer> {
    
}
