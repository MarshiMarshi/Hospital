package br.com.etechoracio.hospital.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Convenio {

    private Integer codigo;
    private String nome;
    private double valor;
}