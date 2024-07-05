package br.com.curso.springkeycloak.repository;

import br.com.curso.springkeycloak.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
