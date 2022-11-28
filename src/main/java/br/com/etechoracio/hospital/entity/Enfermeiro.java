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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.*;
import br.com.etechoracio.hospital.enums.StatusFuncionarioEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name="Enfermeiro")
public class Enfermeiro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="matri_enf")
    private Integer matricula;

    @Column(name="nome_enf")
    private String nome;

    @Column(name="cpf_enf")
    private char cpf;

    @Column(name="endereco_enf")
    private String endereco;

    @Column(name="dtnasc_enf")
    private LocalDate dataNascimento;

    @Column(name="fone_enf", columnDefinition="char")
    private String telefone;

    @Column(name="salario_enf")
    private long salario;

    @Enumerated(EnumType.STRING)
    @Column(name="ativo_enf")
    private StatusFuncionarioEnum status;

    @ManyToOne
    @JoinColumn(name="cod_hosp")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name="cod_cirur")
    private Cirurgia cirurgia;

    @ManyToMany
    @JoinTable(name="Inter_Enf", joinColumns=@JoinColumn(name="matri_enf"), inverseJoinColumns=@JoinColumn(name="cod_inter"))
    private List<Internacao> internacoes;
}
