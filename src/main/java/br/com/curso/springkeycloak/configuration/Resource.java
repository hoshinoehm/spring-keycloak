package br.com.curso.springkeycloak.configuration;

import java.io.InputStream;

public class Resource {
    private InputStream inputStream;
    private String contentType;

    public Resource(InputStream inputStream, String contentType) {
        this.inputStream = inputStream;
        this.contentType = contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}