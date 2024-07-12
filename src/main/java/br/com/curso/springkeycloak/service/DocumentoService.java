package br.com.curso.springkeycloak.service;

import br.com.curso.springkeycloak.configuration.DocumentoNotFoundException;
import br.com.curso.springkeycloak.configuration.Resource;
import br.com.curso.springkeycloak.model.Cliente;
import br.com.curso.springkeycloak.model.Documento;
import br.com.curso.springkeycloak.model.Processo;
import br.com.curso.springkeycloak.model.DocumentoDTO;
import br.com.curso.springkeycloak.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProcessoService processoService;

    private final String uploadDir = "C:\\uploads"; // Defina o diretório onde os arquivos serão salvos

    public Documento salvarDocumento(MultipartFile file, Long clienteId, String operadorId, String descricao) throws IOException {
        Optional<Cliente> clienteOpt = clienteService.findById(clienteId);

        if (!clienteOpt.isPresent()) {
            throw new RuntimeException("Cliente não encontrados");
        }

        // Salva o arquivo no sistema de arquivos
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());

        // Cria o objeto Documento e preenche os dados
        Documento documento = new Documento();
        documento.setNomeDocumento(fileName);
        documento.setDescricao(descricao);
        documento.setDataCriacao(LocalDateTime.now().toString());
        documento.setCaminho(filePath.toString());
        clienteOpt.ifPresent(documento::setCliente);
        documento.setResponsavel(operadorId);


        // Salva o documento no banco de dados
        return documentoRepository.save(documento);
    }

    public Documento buscarDocumentoPorId(Long id) {
        return documentoRepository.findById(id).orElseThrow(() -> new DocumentoNotFoundException("Documento com ID " + id + " não encontrado."));
    }

    public List<DocumentoDTO> getAllDocumentos() {
        return documentoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Resource getDocumentoResource(Long id) throws IOException {
        Documento documento = buscarDocumentoPorId(id);
        String filePath = documento.getCaminho();
        File file = new File(filePath);

        if (!file.exists()) {
            throw new RuntimeException("Arquivo não encontrado: " + filePath);
        }

        InputStream inputStream = new FileInputStream(file);
        String contentType = Files.probeContentType(file.toPath());
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return new Resource(inputStream, contentType);
    }

    public DocumentoDTO convertToDTO(Documento documento) {
        DocumentoDTO dto = new DocumentoDTO();
        dto.setId(documento.getId());
        dto.setNomeDocumento(documento.getNomeDocumento());
        dto.setDescricao(documento.getDescricao());
        dto.setDataCriacao(documento.getDataCriacao());
        dto.setNomeCliente(documento.getCliente() != null ? documento.getCliente().getNome() : "N/A");
        return dto;
    }

    public Documento editarDocumento(Long id, MultipartFile file, Long clienteId, String operadorId, String descricao) throws IOException {
        Documento documento = buscarDocumentoPorId(id);
        Optional<Cliente> clienteOpt = clienteService.findById(clienteId);

        if (!clienteOpt.isPresent()) {
            throw new RuntimeException("Cliente não encontrado");
        }

        // Atualiza os dados do documento
        if (file != null && !file.isEmpty()) {
            // Remove o arquivo antigo
            Path oldFilePath = Paths.get(documento.getCaminho());
            Files.deleteIfExists(oldFilePath);

            // Salva o novo arquivo
            String fileName = file.getOriginalFilename();
            Path newFilePath = Paths.get(uploadDir, fileName);
            Files.write(newFilePath, file.getBytes());
            documento.setNomeDocumento(fileName);
            documento.setCaminho(newFilePath.toString());
        }

        documento.setDescricao(descricao);
        clienteOpt.ifPresent(documento::setCliente);
        documento.setResponsavel(operadorId);

        return documentoRepository.save(documento);
    }

    public void deletarDocumento(Long id) {
        Documento documento = buscarDocumentoPorId(id);
        Path filePath = Paths.get(documento.getCaminho());
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao deletar o arquivo: " + filePath.toString());
        }
        documentoRepository.delete(documento);
    }
}
