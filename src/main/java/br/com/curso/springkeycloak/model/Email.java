package br.com.curso.springkeycloak.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Ex: Comercial, Pessoal, etc.
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
