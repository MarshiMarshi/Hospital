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

import br.com.etechoracio.hospital.enums.TipoExameEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name="Exame")
public class Exame {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_exame")
    private Integer codigo;

    @Column(name="nome_exame")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_exame")
    private TipoExameEnum tipo;

    @Column(name="dthora_exame")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name="cod_pron")
    private Prontuario prontuario;
}
