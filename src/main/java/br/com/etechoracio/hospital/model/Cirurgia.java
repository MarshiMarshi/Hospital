package br.com.etechoracio.hospital.model;

import java.time.LocalDateTime;

import br.com.etechoracio.hospital.enuns.TipoCirurgiaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cirurgia {
    
    private Integer codigo;
    private LocalDateTime dataHora;
    private TipoCirurgiaEnum tipo;
    private Prontuario prontuario;
}
