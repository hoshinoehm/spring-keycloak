package br.com.curso.springkeycloak.repository;

import br.com.curso.springkeycloak.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}
