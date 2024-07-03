package br.com.danielbrai.core.models;

import br.com.danielbrai.core.exceptions.TrainingAlreadyInitializedException;
import br.com.danielbrai.core.exceptions.TrainingReachedTheEndException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingRun {
    private Long id;
    private LocalDateTime executedAt;
    private ExerciseRun exerciseRun;
    private Program program;

    public void startTraining(Program program) {

        if (Objects.nonNull(this.exerciseRun)) {
            throw new TrainingAlreadyInitializedException("Exercício já inicializado!");
        }

        this.program = program;

        ExerciseSetup firstExercise = this.program.getExercises().stream()
                .min(Comparator.comparing(ExerciseSetup::getOrder))
                .orElseThrow(NoSuchElementException::new);

        this.exerciseRun = new ExerciseRun(firstExercise);
    }

    public void addExecutionToCurrentExercise() {
        int currentRun = this.exerciseRun.getHead().getCurrentExecution();
        int exerciseTotalRuns = this.exerciseRun.getHead().getCurrentExercise().getRuns();
        if (currentRun < exerciseTotalRuns) {
            this.exerciseRun.getHead().increaseExecution();
        } else {
            int orderFromNextExercise = this.exerciseRun.getHead().getCurrentExercise().getOrder() + 1;
            ExerciseSetup exerciseSetup = this.program.getExercises().stream()
                    .filter(e -> e.getOrder() == orderFromNextExercise)
                    .findFirst()
                    .orElseThrow(TrainingReachedTheEndException::new);
            this.exerciseRun.add(exerciseSetup);
            this.exerciseRun.getHead().increaseExecution();
        }
    }


}
