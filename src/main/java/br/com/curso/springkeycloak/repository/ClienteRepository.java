package br.com.curso.springkeycloak.repository;

import br.com.curso.springkeycloak.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Cliente> searchClientesByName(@Param("search") String search);
}
