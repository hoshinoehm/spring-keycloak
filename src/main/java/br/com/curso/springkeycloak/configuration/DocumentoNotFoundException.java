package br.com.curso.springkeycloak.configuration;

public class DocumentoNotFoundException extends RuntimeException {
    public DocumentoNotFoundException(String message) {
        super(message);
    }
}
