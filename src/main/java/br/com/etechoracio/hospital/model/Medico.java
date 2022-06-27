package br.com.etechoracio.hospital.model;

import java.time.LocalDate;

import br.com.etechoracio.hospital.enuns.StatusMedicoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Medico {
    
    private Integer crm;
    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private char cpf;
    private String telefone;
    private StatusMedicoEnum status;
    private double salario;
    private Hospital hospital;
}
