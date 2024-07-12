package br.com.curso.springkeycloak.repository;

import br.com.curso.springkeycloak.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}