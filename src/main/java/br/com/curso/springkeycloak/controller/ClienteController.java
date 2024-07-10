package br.com.curso.springkeycloak.controller;

import br.com.curso.springkeycloak.model.Cliente;
import br.com.curso.springkeycloak.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        initializeCollections(cliente);
        Cliente savedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(savedCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> existingClienteOptional = clienteRepository.findById(id);
        if (!existingClienteOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Cliente existingCliente = existingClienteOptional.get();
        updateCollections(existingCliente, cliente);
        copyClienteProperties(existingCliente, cliente);

        Cliente updatedCliente = clienteRepository.save(existingCliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteOptional.get());
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    private void initializeCollections(Cliente cliente) {
        if (cliente.getEmails() == null) {
            cliente.setEmails(new ArrayList<>());
        }
        if (cliente.getTelefones() == null) {
            cliente.setTelefones(new ArrayList<>());
        }
        if (cliente.getEnderecos() == null) {
            cliente.setEnderecos(new ArrayList<>());
        }
        if (cliente.getDocumentos() == null) {
            cliente.setDocumentos(new ArrayList<>());
        }
    }

    private void updateCollections(Cliente existingCliente, Cliente cliente) {
        existingCliente.getEmails().clear();
        existingCliente.getEmails().addAll(cliente.getEmails());
        existingCliente.getEmails().forEach(email -> email.setCliente(existingCliente));

        existingCliente.getTelefones().clear();
        existingCliente.getTelefones().addAll(cliente.getTelefones());
        existingCliente.getTelefones().forEach(telefone -> telefone.setCliente(existingCliente));

        existingCliente.getEnderecos().clear();
        existingCliente.getEnderecos().addAll(cliente.getEnderecos());
        existingCliente.getEnderecos().forEach(endereco -> endereco.setCliente(existingCliente));

        existingCliente.getDocumentos().clear();
        existingCliente.getDocumentos().addAll(cliente.getDocumentos());
        existingCliente.getDocumentos().forEach(documento -> documento.setCliente(existingCliente));
    }

    private void copyClienteProperties(Cliente existingCliente, Cliente cliente) {
        existingCliente.setTipo(cliente.getTipo());
        existingCliente.setPerfil(cliente.getPerfil());
        existingCliente.setNome(cliente.getNome());
        existingCliente.setApelido(cliente.getApelido());
        existingCliente.setSite(cliente.getSite());
        existingCliente.setNascimento(cliente.getNascimento());
        existingCliente.setEmpresa(cliente.getEmpresa());
        existingCliente.setProfissao(cliente.getProfissao());
        existingCliente.setAtividadeEconomica(cliente.getAtividadeEconomica());
        existingCliente.setEstadoCivil(cliente.getEstadoCivil());
        existingCliente.setTratamento(cliente.getTratamento());
        existingCliente.setCodigo(cliente.getCodigo());
        existingCliente.setPai(cliente.getPai());
        existingCliente.setMae(cliente.getMae());
        existingCliente.setNaturalidade(cliente.getNaturalidade());
        existingCliente.setNacionalidade(cliente.getNacionalidade());
        existingCliente.setComentarios(cliente.getComentarios());
        existingCliente.setCpf(cliente.getCpf());
        existingCliente.setRg(cliente.getRg());
        existingCliente.setCtps(cliente.getCtps());
        existingCliente.setPis(cliente.getPis());
        existingCliente.setTituloEleitor(cliente.getTituloEleitor());
        existingCliente.setCnh(cliente.getCnh());
        existingCliente.setPassaporte(cliente.getPassaporte());
        existingCliente.setCertidaoReservista(cliente.getCertidaoReservista());
        existingCliente.setNomeFantasia(cliente.getNomeFantasia());
        existingCliente.setCnpj(cliente.getCnpj());
        existingCliente.setInscricaoEstadual(cliente.getInscricaoEstadual());
        existingCliente.setInscricaoMunicipal(cliente.getInscricaoMunicipal());
        existingCliente.setOptanteSimplesNacional(cliente.isOptanteSimplesNacional());
        existingCliente.setContaCorrente(cliente.getContaCorrente());
        existingCliente.setContaPoupanca(cliente.getContaPoupanca());
        existingCliente.setBanco(cliente.getBanco());
        existingCliente.setAgencia(cliente.getAgencia());
        existingCliente.setConta(cliente.getConta());
        existingCliente.setPix(cliente.getPix());
    }
}
