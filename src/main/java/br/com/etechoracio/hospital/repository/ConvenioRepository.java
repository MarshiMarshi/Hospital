package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Convenio;

public interface ConvenioRepository extends JpaRepository<Convenio, Integer> {
    
}
