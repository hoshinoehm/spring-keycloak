package br.com.curso.springkeycloak.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;
import java.util.Optional;

@Data
@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDocumento;
    private String descricao;
    private String dataCriacao;
    private String origem;
    private String caminho;
    private String responsavel;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;

}
