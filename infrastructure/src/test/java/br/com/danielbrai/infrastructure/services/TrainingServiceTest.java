package br.com.danielbrai.infrastructure.services;

import br.com.danielbrai.core.models.*;
import br.com.danielbrai.infrastructure.repositories.TrainingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TrainingServiceTest {

    @InjectMocks
    TrainingService trainingService;

    MockedStatic<TrainingRepository> trainingRepository;

    @BeforeEach
    public void setup() {
        this.trainingRepository = Mockito.mockStatic(TrainingRepository.class);
    }

    @AfterEach
    public void tearDown() {
        this.trainingRepository.close();
    }

    @Test
    void shouldIncreaseExerciseRun() {

        Exercise supinoConvergente = Exercise.builder()
                .id(1L)
                .name("Supino Convergente")
                .build();

        Exercise flyLife = Exercise.builder()
                .id(2L)
                .name("Fly Life")
                .build();

        ExerciseSetup supinoCanadenceSetup = ExerciseSetup.builder()
                .runs(4)
                .order(1)
                .recover(120)
                .executions(8)
                .charge(18.5F)
                .exercise(supinoConvergente)
                .id(1L)
                .build();

        ExerciseSetup peckDeckSetup = ExerciseSetup.builder()
                .runs(4)
                .order(2)
                .recover(120)
                .executions(8)
                .charge(55.F)
                .exercise(flyLife)
                .id(2L)
                .build();

        List<ExerciseSetup> exerciseSetupList = Arrays.asList(
                supinoCanadenceSetup,
                peckDeckSetup
        );

        Program program = Program.builder()
                .exercises(exerciseSetupList)
                .gymMember(User.builder()
                        .name("Godofredo Josinaldo")
                        .id(1L)
                        .build())
                .startedAt(LocalDate.of(2024, 6, 27))
                .id(1L)
                .build();

        TrainingRun trainingRun = new TrainingRun();
        trainingRun.startTraining(program);
        trainingRun.setId(1L);

        trainingRepository
                .when(() -> TrainingRepository.getTrainingById(Mockito.anyLong()))
                .thenReturn(trainingRun);

        TrainingRun returnedtrainingRun = trainingService.increaseCount(1L);

        Assertions.assertEquals(1, returnedtrainingRun.getExerciseRun().getHead().getCurrentExercise().getExercise().getId());
        Assertions.assertEquals(1, returnedtrainingRun.getExerciseRun().getHead().getCurrentExecution());

    }

}