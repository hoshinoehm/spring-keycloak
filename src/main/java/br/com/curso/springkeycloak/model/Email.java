package br.com.curso.springkeycloak.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Getters and Setters
}