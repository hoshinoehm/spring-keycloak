package br.com.curso.springkeycloak.controller;

import br.com.curso.springkeycloak.model.ToDo;
import br.com.curso.springkeycloak.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<ToDo> getAllToDos(@RequestParam String userId) {
        return toDoService.findByUserId(userId);
    }

    @PostMapping
    public ToDo createToDo(@RequestBody ToDo toDo) {
        toDo.setCreatedAt(LocalDateTime.now());
        return toDoService.save(toDo);
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable Long id, @RequestBody ToDo toDo) {
        if (toDo.isCompleted()) {
            toDo.setCompletedAt(LocalDateTime.now());
        } else {
            toDo.setCompletedAt(null);
        }
        return toDoService.save(toDo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id) {
        toDoService.deleteById(id);
    }
}
