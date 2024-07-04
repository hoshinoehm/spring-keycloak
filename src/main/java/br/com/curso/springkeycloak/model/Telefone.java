package br.com.curso.springkeycloak.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Ex: Comercial, Celular, etc.
    private String numero;
    private String operadora;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Getters and Setters
}
