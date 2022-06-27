package br.com.etechoracio.hospital.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoricoConsulta {
    
    private Integer codigo;
    private String assinatura;
    private String prescricao;
    private Prontuario prontuario;
}
