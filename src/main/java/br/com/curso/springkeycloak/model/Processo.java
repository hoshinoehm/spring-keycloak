package br.com.curso.springkeycloak.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Data
@Entity
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroProcesso;
    private String acao;
    private String objeto;
    private String juizo;
    private String linkTribunal;
    private String observacoes;
    private Double valorCausa;
    private Double valorCondenacao;
    private String distribuidoEm;
    private String criadoEm;
    private String ultimosHistoricos;
    private String recursosDesdobramentos;

    @ManyToMany(mappedBy = "processos")
    @JsonIgnore  // Adicione esta anotação para evitar a recursão infinita
    private List<Documento> documentos;
}
