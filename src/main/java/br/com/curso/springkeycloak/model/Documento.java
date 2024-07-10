package br.com.curso.springkeycloak.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

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


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "processo_documento",
            joinColumns = @JoinColumn(name = "documento_id"),
            inverseJoinColumns = @JoinColumn(name = "processo_id")
    )
    private List<Processo> processos;
}
