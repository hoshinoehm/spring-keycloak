package br.com.curso.springkeycloak.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentoDTO {
    private Long id;
    private String nomeDocumento;
    private String descricao;
    private String dataCriacao;
    private String origem;
    private String caminho;
    private String responsavel;
    private String nomeCliente;

}