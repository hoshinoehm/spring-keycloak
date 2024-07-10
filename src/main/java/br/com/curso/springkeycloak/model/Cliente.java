package br.com.curso.springkeycloak.model;

import br.com.curso.springkeycloak.model.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    private String perfil;
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

    // Documentação Pessoa Física
    private String cpf;
    private String rg;
    private String ctps;
    private String pis;
    private String tituloEleitor;
    private String cnh;
    private String passaporte;
    private String certidaoReservista;

    // Documentação Pessoa Jurídica
    private String nomeFantasia;
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

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Email> emails;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Documento> documentos;

    // getters e setters
}