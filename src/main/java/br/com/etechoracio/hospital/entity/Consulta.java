package br.com.etechoracio.hospital.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name="Consulta")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_cons")
    private Integer codigo;

    @Column(name="data_cons")
    private LocalDate data;

    @Column(name="hora_cons")
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name="crm_med")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name="cod_pron")
    private Prontuario prontuario;
}
