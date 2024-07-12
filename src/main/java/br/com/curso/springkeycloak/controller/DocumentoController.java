package br.com.curso.springkeycloak.controller;
import br.com.curso.springkeycloak.configuration.Resource;
import br.com.curso.springkeycloak.model.Documento;
import br.com.curso.springkeycloak.model.DocumentoDTO;
import br.com.curso.springkeycloak.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping
    public ResponseEntity<List<DocumentoDTO>> getAllDocumentos() {
        List<DocumentoDTO> documentos = documentoService.getAllDocumentos();
        return ResponseEntity.ok(documentos);
    }

    @PostMapping("/upload")
    public ResponseEntity<DocumentoDTO> uploadDocumento(
            @RequestParam("file") MultipartFile file,
            @RequestParam("clienteId") Long clienteId,
            @RequestParam("operadorId") String operadorId,
            @RequestParam("descricao") String descricao) {
        try {
            Documento documento = documentoService.salvarDocumento(file, clienteId, operadorId, descricao);
            DocumentoDTO dto = documentoService.convertToDTO(documento);
            return ResponseEntity.ok(dto);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<InputStreamResource> viewDocumento(@PathVariable Long id) {
        try {
            Resource resource = documentoService.getDocumentoResource(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, resource.getContentType());
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + id + "\"");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(new InputStreamResource(resource.getInputStream()));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
