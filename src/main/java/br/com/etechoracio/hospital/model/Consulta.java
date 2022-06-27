package br.com.etechoracio.hospital.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Consulta {
    
    private Integer codigo;
    private LocalDate data;
    private LocalTime hora;
    private Medico medico;
    private Prontuario prontuario;
}
