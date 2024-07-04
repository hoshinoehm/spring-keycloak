package br.com.curso.springkeycloak.service;

import br.com.curso.springkeycloak.model.User;
import org.springframework.http.ResponseEntity;

public interface LoginService<T> {
    ResponseEntity<T> login(User user);
    ResponseEntity<T> refreshToken(String refreshToken);

}
