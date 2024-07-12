package br.com.curso.springkeycloak.repository;

import br.com.curso.springkeycloak.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByUserId(String userId);
}
