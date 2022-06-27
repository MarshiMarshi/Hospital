package br.com.etechoracio.hospital.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Remedio {
    
    private Integer codigo;
    private String nome;
    private String fabricante;
    private LocalDate dataValidade;
    private LocalDate dataFabricacao;
    private HistoricoConsulta historicoConsulta;
}
