package br.com.curso.springkeycloak.service;

import br.com.curso.springkeycloak.model.Processo;
import java.util.List;
import java.util.Optional;

public interface ProcessoService {
    List<Processo> findAll();
    Optional<Processo> findById(Long id);
    Processo save(Processo processo);
    void deleteById(Long id);
}
