package br.com.curso.springkeycloak.service;

import br.com.curso.springkeycloak.model.Processo;
import br.com.curso.springkeycloak.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository processoRepository;

    public List<Processo> findAll() {
        return processoRepository.findAll();
    }

    public Optional<Processo> findById(Long id) {
        return processoRepository.findById(id);
    }

    public Processo save(Processo processo) {
        return processoRepository.save(processo);
    }

    public void deleteById(Long id) {
        processoRepository.deleteById(id);
    }
}
