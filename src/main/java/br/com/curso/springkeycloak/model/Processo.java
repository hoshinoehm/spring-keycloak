package br.com.curso.springkeycloak.model;

import jakarta.persistence.*;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Cliente autor;

    @ManyToMany(mappedBy = "processos")
    private List<Documento> documentos;


}