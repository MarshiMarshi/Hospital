package br.com.etechoracio.hospital.entity;

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
@Table(name="Hist_cons")
public class HistoricoConsulta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_hist")
    private Integer codigo;

    @Column(name="assi_hist")
    private String assinatura;

    @Column(name="prescricao_hist")
    private String prescricao;

    @ManyToOne
    @JoinColumn(name="cod_pron")
    private Prontuario prontuario;
}
