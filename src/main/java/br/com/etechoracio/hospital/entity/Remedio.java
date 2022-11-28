package br.com.etechoracio.hospital.entity;

import java.time.LocalDate;

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
@Table(name="Remedio")
public class Remedio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_reme")
    private Integer codigo;

    @Column(name="nome_reme")
    private String nome;

    @Column(name="fabri_reme")
    private String fabricante;

    @Column(name="dtvali_reme")
    private LocalDate dataValidade;

    @Column(name="dtfabri_reme")
    private LocalDate dataFabricacao;

    @ManyToOne
    @JoinColumn(name="cod_hist")
    private HistoricoConsulta historicoConsulta;
}
