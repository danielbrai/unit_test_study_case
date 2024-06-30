package br.com.danielbrai.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class TrainingProgram {
    private Long id;
    private List<ExerciseSetup> exercises;
    private LocalDate startedAt;
    private LocalDate endedAt;
}
