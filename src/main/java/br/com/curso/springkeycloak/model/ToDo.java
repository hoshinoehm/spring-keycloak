package br.com.curso.springkeycloak.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
    private String userId; // O campo para armazenar o ID do usuário
}
