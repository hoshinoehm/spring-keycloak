package br.com.curso.springkeycloak.controller;

import br.com.curso.springkeycloak.model.Processo;
import br.com.curso.springkeycloak.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/processos")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @GetMapping
    public List<Processo> getAllProcessos() {
        return processoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Processo> getProcessoById(@PathVariable Long id) {
        Optional<Processo> processo = processoService.findById(id);
        return processo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Processo createProcesso(@RequestBody Processo processo) {
        return processoService.save(processo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Processo> updateProcesso(@PathVariable Long id, @RequestBody Processo processo) {
        if (!processoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        processo.setId(id);
        return ResponseEntity.ok(processoService.save(processo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcesso(@PathVariable Long id) {
        if (!processoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        processoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
