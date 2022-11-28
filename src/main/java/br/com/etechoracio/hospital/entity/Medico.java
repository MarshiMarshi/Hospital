package br.com.etechoracio.hospital.entity;

import java.time.LocalDate;

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

import br.com.etechoracio.hospital.enums.StatusMedicoEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name="Medico")
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="crm_med")
    private Integer crm;

    @Column(name="nome_med")
    private String nome;

    @Column(name="dtnasc_med")
    private LocalDate dataNascimento;

    @Column(name="endereco_med")
    private String endereco;

    @Column(name="cpf_med")
    private char cpf;

    @Column(name="fone_med", columnDefinition="char")
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name="ativo_med")
    private StatusMedicoEnum status;

    @Column(name="salario_med")
    private long salario;

    @ManyToOne
    @JoinColumn(name="cod_hosp")
    private Hospital hospital;
}
