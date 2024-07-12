package br.com.curso.springkeycloak.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Data
@Entity
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroProcesso;
    private String descricao;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "processo_documento",
            joinColumns = @JoinColumn(name = "processo_id"),
            inverseJoinColumns = @JoinColumn(name = "documento_id")
    )
    private List<Documento> documentos;
}
