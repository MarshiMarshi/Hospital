package br.com.etechoracio.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.hospital.entity.Internacao;

public interface InternacaoRepository extends JpaRepository<Internacao, Integer> {
    
}
