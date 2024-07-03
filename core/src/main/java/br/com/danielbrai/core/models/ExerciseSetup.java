package br.com.danielbrai.core.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExerciseSetup {

    private Long id;
    private Exercise exercise;
    private Float charge;
    private Integer runs;
    private Integer executions;
    private Integer recover;
    private Integer order;
}
