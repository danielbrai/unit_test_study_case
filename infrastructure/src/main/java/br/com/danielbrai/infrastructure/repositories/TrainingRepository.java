package br.com.danielbrai.infrastructure.repositories;

import br.com.danielbrai.core.models.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class TrainingRepository {

    private static TrainingRun trainingRun;

    public static TrainingRun getTrainingById(Long trainingId) {

        Exercise supinoConvergente = Exercise.builder()
                .id(1L)
                .name("Supino Convergente")
                .build();

        Exercise flyLife = Exercise.builder()
                .id(2L)
                .name("Fly Life")
                .build();

        Exercise supinoInclinadoSmith = Exercise.builder()
                .id(3L)
                .name("Supino Inclinado Smith")
                .build();

        Exercise elevacaoLateralComHalter = Exercise.builder()
                .id(4L)
                .name("Elevação Lateral com Halteres")
                .build();

        Exercise elevacaoFrontalNaPoliaComCorda = Exercise.builder()
                .id(5L)
                .name("Elevação Frontal na Polia com Corda")
                .build();

        Exercise tricepsFrancesNaPoliaComCorda = Exercise.builder()
                .id(6L)
                .name("Tríceps Francês na Polia com Corda")
                .build();

        Exercise tricepsNaPoliaComBarraW = Exercise.builder()
                .id(7L)
                .name("Tríceps na Polia com Barra W")
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

        ExerciseSetup supinoInclinadoSmithSetup = ExerciseSetup.builder()
                .runs(4)
                .order(3)
                .recover(120)
                .executions(8)
                .charge(17.5F)
                .exercise(supinoInclinadoSmith)
                .id(3L)
                .build();

        ExerciseSetup elevacaoLateralComHalterSetup = ExerciseSetup.builder()
                .runs(4)
                .order(4)
                .recover(120)
                .executions(8)
                .charge(9.F)
                .exercise(elevacaoLateralComHalter)
                .id(4L)
                .build();

        ExerciseSetup elevacaoFrontalNaPoliaComCordaSetup = ExerciseSetup.builder()
                .runs(4)
                .order(5)
                .recover(120)
                .executions(8)
                .charge(2.F)
                .exercise(elevacaoFrontalNaPoliaComCorda)
                .id(5L)
                .build();

        ExerciseSetup tricepsFrancesNaPoliaComCordaSetup = ExerciseSetup.builder()
                .runs(4)
                .order(6)
                .recover(120)
                .executions(8)
                .charge(4.F)
                .exercise(tricepsFrancesNaPoliaComCorda)
                .id(6L)
                .build();

        ExerciseSetup tricepsNaPoliaComBarraWSetup = ExerciseSetup.builder()
                .runs(4)
                .order(7)
                .recover(120)
                .executions(8)
                .charge(9.F)
                .exercise(tricepsNaPoliaComBarraW)
                .id(7L)
                .build();

        List<ExerciseSetup> exerciseSetupList = Arrays.asList(
                supinoCanadenceSetup,
                peckDeckSetup,
                supinoInclinadoSmithSetup,
                elevacaoLateralComHalterSetup,
                elevacaoFrontalNaPoliaComCordaSetup,
                tricepsFrancesNaPoliaComCordaSetup,
                tricepsNaPoliaComBarraWSetup
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

        if (Objects.nonNull(trainingRun)) {
            return trainingRun;
        }

        trainingRun = new TrainingRun();
        trainingRun.startTraining(program);
        trainingRun.setId(trainingId);
        return trainingRun;
    }
}
