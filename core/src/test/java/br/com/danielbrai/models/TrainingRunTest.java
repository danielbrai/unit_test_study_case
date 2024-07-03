package br.com.danielbrai.models;

import br.com.danielbrai.core.exceptions.TrainingAlreadyInitializedException;
import br.com.danielbrai.core.exceptions.TrainingReachedTheEndException;
import br.com.danielbrai.core.models.Exercise;
import br.com.danielbrai.core.models.ExerciseSetup;
import br.com.danielbrai.core.models.Program;
import br.com.danielbrai.core.models.TrainingRun;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class TrainingRunTest {

    @InjectMocks
    TrainingRun trainingRun;


    @Test
    void shouldIndicateThatTheTrainingIsAlreadyRunningIfTheInitializationIsCalledTwice() {

        /*
         * GIVEN or ARRANGE
         *
         * Build the test DOCs and test doubles used in the scenario; Setting up the mocked that is used by SUT.
         */
        Exercise supinoCanadense = Exercise.builder()
                .id(1L)
                .name("Supino Canadense")
                .build();

        Exercise peckDeck = Exercise.builder()
                .id(2L)
                .name("Peck Deck")
                .build();

        ExerciseSetup supinoCanadenceSetup = ExerciseSetup.builder()
                .runs(4)
                .order(1)
                .recover(120)
                .executions(8)
                .charge(40.F)
                .exercise(supinoCanadense)
                .build();

        ExerciseSetup peckDeckSetup = ExerciseSetup.builder()
                .runs(4)
                .order(1)
                .recover(120)
                .executions(8)
                .charge(80.F)
                .exercise(peckDeck)
                .build();

        List<ExerciseSetup> exerciseSetupList = Arrays.asList(supinoCanadenceSetup, peckDeckSetup);

        Program program = Program.builder()
                .exercises(exerciseSetupList)
                .startedAt(LocalDate.of(2024, 6, 27))
                .id(1L)
                .build();

        this.trainingRun.startTraining(program);

        assertThrows(TrainingAlreadyInitializedException.class, () -> this.trainingRun.startTraining(program));
        assertEquals(0, this.trainingRun.getExerciseRun().getHead().getCurrentExecution());

    }

    @Test
    void shouldIncrementTheExecutionOfCurrentExerciseIfIsTheFirstTimeThatTheIncrementOccurs() {

        /*
         * GIVEN or ARRANGE
         *
         * Build the test DOCs and test doubles used in the scenario; Setting up the mocked that is used by SUT.
         */
        Exercise supinoCanadense = Exercise.builder()
                .id(1L)
                .name("Supino Canadense")
                .build();

        Exercise peckDeck = Exercise.builder()
                .id(2L)
                .name("Peck Deck")
                .build();

        ExerciseSetup supinoCanadenceSetup = ExerciseSetup.builder()
                .runs(4)
                .order(1)
                .recover(120)
                .executions(8)
                .charge(40.F)
                .exercise(supinoCanadense)
                .build();

        ExerciseSetup peckDeckSetup = ExerciseSetup.builder()
                .runs(4)
                .order(1)
                .recover(120)
                .executions(8)
                .charge(80.F)
                .exercise(peckDeck)
                .build();

        List<ExerciseSetup> exerciseSetupList = Arrays.asList(supinoCanadenceSetup, peckDeckSetup);

        Program program = Program.builder()
                .exercises(exerciseSetupList)
                .startedAt(LocalDate.of(2024, 6, 27))
                .id(1L)
                .build();

        this.trainingRun.startTraining(program);

        /*
         * ACT or WHEN
         *
         * Execute the method under test
         */
        this.trainingRun.addExecutionToCurrentExercise();

        /*
         * ASSERT or THEN
         *
         * Do verifications over the result of SUT or the DOCs injected in it.
         */

        assertEquals(1, this.trainingRun.getExerciseRun().getHead().getCurrentExecution());

    }


    @Test
    void shouldIncrementTheExecutionOfCurrentExerciseIfIsTheSecondTimeThatTheIncrementOccurs() {

        /*
         * GIVEN or ARRANGE
         *
         * Build the test DOCs and test doubles used in the scenario; Setting up the mocked that is used by SUT.
         */
        Exercise supinoCanadense = Exercise.builder()
                .id(1L)
                .name("Supino Canadense")
                .build();

        Exercise peckDeck = Exercise.builder()
                .id(2L)
                .name("Peck Deck")
                .build();

        ExerciseSetup supinoCanadenceSetup = ExerciseSetup.builder()
                .runs(4)
                .order(1)
                .recover(120)
                .executions(8)
                .charge(40.F)
                .exercise(supinoCanadense)
                .build();

        ExerciseSetup peckDeckSetup = ExerciseSetup.builder()
                .runs(4)
                .order(1)
                .recover(120)
                .executions(8)
                .charge(80.F)
                .exercise(peckDeck)
                .build();

        List<ExerciseSetup> exerciseSetupList = Arrays.asList(supinoCanadenceSetup, peckDeckSetup);

        Program program = Program.builder()
                .exercises(exerciseSetupList)
                .startedAt(LocalDate.of(2024, 6, 27))
                .id(1L)
                .build();

        this.trainingRun.startTraining(program);
        this.trainingRun.addExecutionToCurrentExercise();

        /*
         * ACT or WHEN
         *
         * Execute the method under test
         */
        this.trainingRun.addExecutionToCurrentExercise();

        /*
         * ASSERT or THEN
         *
         * Do verifications over the result of SUT or the DOCs injected in it.
         */

        assertEquals(2, this.trainingRun.getExerciseRun().getHead().getCurrentExecution());
    }


    @Test
    void shouldIncrementTheExecutionOfCurrentExerciseIfIsTheLastTimeThatTheIncrementOccurs() {

        /*
         * GIVEN or ARRANGE
         *
         * Build the test DOCs and test doubles used in the scenario; Setting up the mocked that is used by SUT.
         */
        Exercise supinoCanadense = Exercise.builder()
                .id(1L)
                .name("Supino Canadense")
                .build();

        Exercise peckDeck = Exercise.builder()
                .id(2L)
                .name("Peck Deck")
                .build();

        ExerciseSetup supinoCanadenceSetup = ExerciseSetup.builder()
                .runs(4)
                .order(1)
                .recover(120)
                .executions(8)
                .charge(40.F)
                .exercise(supinoCanadense)
                .build();

        ExerciseSetup peckDeckSetup = ExerciseSetup.builder()
                .runs(4)
                .order(2)
                .recover(120)
                .executions(8)
                .charge(80.F)
                .exercise(peckDeck)
                .build();

        List<ExerciseSetup> exerciseSetupList = Arrays.asList(supinoCanadenceSetup, peckDeckSetup);

        Program program = Program.builder()
                .exercises(exerciseSetupList)
                .startedAt(LocalDate.of(2024, 6, 27))
                .id(1L)
                .build();

        this.trainingRun.startTraining(program);
        this.trainingRun.addExecutionToCurrentExercise();
        this.trainingRun.addExecutionToCurrentExercise();
        this.trainingRun.addExecutionToCurrentExercise();
        this.trainingRun.addExecutionToCurrentExercise();

        /*
         * ACT or WHEN
         *
         * Execute the method under test
         */
        this.trainingRun.addExecutionToCurrentExercise();

        /*
         * ASSERT or THEN
         *
         * Do verifications over the result of SUT or the DOCs injected in it.
         */

        assertEquals(1, this.trainingRun.getExerciseRun().getHead().getCurrentExecution());
        assertEquals("Peck Deck", this.trainingRun.getExerciseRun().getHead().getCurrentExercise().getExercise().getName());
        assertEquals(4, this.trainingRun.getExerciseRun().getHead().getPreviousRun().getCurrentExecution());
    }


    @Test
    void shouldThrowsAnExceptionWhenThereAreNoMoreExercisesInTraining() {

        /*
         * GIVEN or ARRANGE
         *
         * Build the test DOCs and test doubles used in the scenario; Setting up the mocked that is used by SUT.
         */
        Exercise supinoCanadense = Exercise.builder()
                .id(1L)
                .name("Supino Canadense")
                .build();

        ExerciseSetup supinoCanadenceSetup = ExerciseSetup.builder()
                .runs(4)
                .order(1)
                .recover(120)
                .executions(8)
                .charge(40.F)
                .exercise(supinoCanadense)
                .build();

        List<ExerciseSetup> exerciseSetupList = Collections.singletonList(supinoCanadenceSetup);

        Program program = Program.builder()
                .exercises(exerciseSetupList)
                .startedAt(LocalDate.of(2024, 6, 27))
                .id(1L)
                .build();

        this.trainingRun.startTraining(program);
        this.trainingRun.addExecutionToCurrentExercise();
        this.trainingRun.addExecutionToCurrentExercise();
        this.trainingRun.addExecutionToCurrentExercise();
        this.trainingRun.addExecutionToCurrentExercise();

        /*
         * ACT or WHEN
         *
         * Execute the method under test
         */
        assertThrows(TrainingReachedTheEndException.class, () -> this.trainingRun.addExecutionToCurrentExercise());

        /*
         * ASSERT or THEN
         *
         * Do verifications over the result of SUT or the DOCs injected in it.
         */

        assertEquals(4, this.trainingRun.getExerciseRun().getHead().getCurrentExecution());
        assertEquals("Supino Canadense", this.trainingRun.getExerciseRun().getHead().getCurrentExercise().getExercise().getName());
    }
}