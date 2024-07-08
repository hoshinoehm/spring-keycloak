package br.com.curso.springkeycloak.service.implementations;

import br.com.curso.springkeycloak.model.Processo;
import br.com.curso.springkeycloak.repository.ProcessoRepository;
import br.com.curso.springkeycloak.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoServiceImpl implements ProcessoService {

    @Autowired
    private ProcessoRepository processoRepository;

    @Override
    public List<Processo> findAll() {
        return processoRepository.findAll();
    }

    @Override
    public Optional<Processo> findById(Long id) {
        return processoRepository.findById(id);
    }

    @Override
    public Processo save(Processo processo) {
        return processoRepository.save(processo);
    }

    @Override
    public void deleteById(Long id) {
        processoRepository.deleteById(id);
    }
}