package br.com.curso.springkeycloak.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class PessoaJuridica extends Cliente {

    private String empresa;
    private String nomeFantasia;
    private String site;
    private String contato;
    private String cargo;
    private String codigo;
    private String comentarios;

    // Documentação
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private boolean optanteSimplesNacional;

    // Conta bancária
    private String contaCorrente;
    private String contaPoupanca;
    private String banco;
    private String agencia;
    private String conta;
    private String pix;

}
