package br.com.danielbrai.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.NoSuchElementException;
import java.util.Objects;

@Getter
public class ExerciseRun {

    private Node head;

    public ExerciseRun(ExerciseSetup exercise) {
        this.head = new Node(exercise);
    }

    @AllArgsConstructor
    @Builder
    @Getter
    static class Node {

        private Node previousRun;
        private ExerciseSetup currentExercise;
        private int currentExecution;
        private Node nextRun;

        public Node (ExerciseSetup exercise) {
            this.currentExercise = exercise;
            this.nextRun = null;
            this.previousRun = null;
        }

        public void increaseExecution() {
            this.currentExecution++;
        }
    }

    public void add (ExerciseSetup exercise) {
        Node current = Node.builder()
                .currentExercise(exercise)
                .nextRun(null)
                .build();
        if (Objects.nonNull(this.head)) {
            Node lastNode = this.head;
            while (Objects.nonNull(lastNode.nextRun)) {
                lastNode = lastNode.nextRun;
            }
            lastNode.nextRun = current;
            current.previousRun = lastNode;
        }
        this.head = current;
    }
}
