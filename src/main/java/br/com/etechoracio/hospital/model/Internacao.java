package br.com.etechoracio.hospital.model;

import java.time.LocalDateTime;

import br.com.etechoracio.hospital.enuns.TipoInternacaoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Internacao {
    
    private Integer codigo;
    private LocalDateTime dataHora;
    private TipoInternacaoEnum tipo;
    private Prontuario prontuario;
}
