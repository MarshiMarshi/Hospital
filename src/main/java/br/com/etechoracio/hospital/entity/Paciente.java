package br.com.etechoracio.hospital.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="Paciente")
public class Paciente {
    
    @Id
    @Column(name="cpf_pac", columnDefinition="integer")
    private char cpf;

    @Column(name="nome_pac")
    private String nome;

    @Column(name="dtnasc_pac")
    private LocalDate dataNascimento;

    @Column(name="endereco_pac")
    private String endereco;

    @Column(name="fone_pac", columnDefinition="char")
    private String telefone;

    @Column(name="peso_pac")
    private long peso;

    @Column(name="altura_pac")
    private long altura;

    @ManyToOne
    @JoinColumn(name="cod_conv")
    private Convenio convenio;
}
