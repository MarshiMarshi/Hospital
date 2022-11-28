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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.etechoracio.hospital.enums.TipoDoencaEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name="Prontuario")
public class Prontuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_pron")
    private Integer codigo;

    @Column(name="observacao_pron")
    private String observacao;

    @Column(name="dtemissao_pron")
    private LocalDateTime dataEmissao;

    @Column(name="hist_fam_pac")
    private String historicoFamiliar;

    @Enumerated(EnumType.STRING)
    @Column(name="doenca_pac")
    private TipoDoencaEnum doenca;

    @ManyToOne
    @JoinColumn(name="crm_med")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name="cod_hosp")
    private Hospital hospital;

    @OneToOne
    @JoinColumn(name="cpf_pac")
    private Paciente paciente;
}
