package br.com.etechoracio.hospital.model;

import java.time.LocalDate;

import br.com.etechoracio.hospital.enuns.TipoDoencaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prontuario {
    
    private Integer codigo;
    private String observacao;
    private LocalDate dataEmissao;
    private String historicoFamiliar;
    private TipoDoencaEnum doenca;
    private Medico medico;
    private Hospital hospital;
    private Paciente paciente;
}
