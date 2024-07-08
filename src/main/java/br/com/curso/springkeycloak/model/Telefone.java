package br.com.curso.springkeycloak.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
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
}
