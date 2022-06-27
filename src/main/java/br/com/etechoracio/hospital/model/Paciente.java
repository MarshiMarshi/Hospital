package br.com.etechoracio.hospital.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paciente {
    
    private char cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private double peso;
    private double altura;
    private Convenio convenio;
}
