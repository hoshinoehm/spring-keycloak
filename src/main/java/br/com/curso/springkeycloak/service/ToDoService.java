package br.com.curso.springkeycloak.service;

import br.com.curso.springkeycloak.model.ToDo;
import br.com.curso.springkeycloak.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> findByUserId(String userId) {
        return toDoRepository.findByUserId(userId);
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public void deleteById(Long id) {
        toDoRepository.deleteById(id);
    }
}
