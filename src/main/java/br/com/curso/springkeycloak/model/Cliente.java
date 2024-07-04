package br.com.curso.springkeycloak.model;

import br.com.curso.springkeycloak.model.Email;
import br.com.curso.springkeycloak.model.Endereco;
import br.com.curso.springkeycloak.model.PessoaFisica;
import br.com.curso.springkeycloak.model.Telefone;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PessoaFisica.class, name = "PessoaFisica"),
        @JsonSubTypes.Type(value = PessoaJuridica.class, name = "PessoaJuridica")
})
public abstract class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String perfil;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;

}
