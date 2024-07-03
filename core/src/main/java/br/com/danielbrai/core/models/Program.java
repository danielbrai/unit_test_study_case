package br.com.danielbrai.core.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Program {
    private Long id;
    private List<ExerciseSetup> exercises;
    private LocalDate startedAt;
    private LocalDate endedAt;
    private User gymMember;
    private User instructor;
}
