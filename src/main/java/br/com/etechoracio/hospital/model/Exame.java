package br.com.etechoracio.hospital.model;

import java.time.LocalDateTime;

import br.com.etechoracio.hospital.enuns.TipoExameEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exame {
    
    private Integer codigo;
    private TipoExameEnum tipo;
    private LocalDateTime dataHora;
    private Prontuario prontuario;
}
