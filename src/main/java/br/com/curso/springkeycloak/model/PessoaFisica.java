package br.com.curso.springkeycloak.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
public class PessoaFisica extends Cliente {

    private String nome;
    private String apelido;
    private String site;
    private Date nascimento;
    private String empresa;
    private String profissao;
    private String atividadeEconomica;
    private String estadoCivil;
    private String tratamento;
    private String codigo;
    private String pai;
    private String mae;
    private String naturalidade;
    private String nacionalidade;
    private String comentarios;

    // Documentação
    private String cpf;
    private String rg;
    private String ctps;
    private String pis;
    private String tituloEleitor;
    private String cnh;
    private String passaporte;
    private String certidaoReservista;

    // Conta bancária
    private String contaCorrente;
    private String contaPoupanca;
    private String banco;
    private String agencia;
    private String conta;
    private String pix;

}
