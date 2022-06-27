package br.com.etechoracio.hospital.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternarEnfermeiro {
    
    private Enfermeiro enfermeiro;
    private Internacao internacao;
}
