package br.com.etechoracio.hospital.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.etechoracio.hospital.enums.TipoCirurgiaEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name="Cirurgia")
public class Cirurgia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_cirur")
    private Integer codigo;

    @Column(name="dthora_cirur")
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_cirur")
    private TipoCirurgiaEnum tipo;

    @ManyToOne
    @JoinColumn(name="cod_pron")
    private Prontuario prontuario;
}
