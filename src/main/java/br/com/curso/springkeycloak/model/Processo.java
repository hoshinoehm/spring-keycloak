package br.com.curso.springkeycloak.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;

@JsonTypeName("PessoaFisica")
@Entity
@Data
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Date dataInicio;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    // Getters and Setters
}
