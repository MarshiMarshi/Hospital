package br.com.etechoracio.hospital.model;

import java.time.LocalDate;

import br.com.etechoracio.hospital.enuns.StatusFuncionarioEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Enfermeiro {
    
    private Integer matricula;
    private String nome;
    private char cpf;
    private String endereco;
    private LocalDate dataNascimento;
    private String telefone;
    private double salario;
    private StatusFuncionarioEnum status;
    private Hospital hospital;
    private Cirurgia cirurgia;
}
