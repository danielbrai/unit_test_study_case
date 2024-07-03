package br.com.danielbrai.core.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String name;
}
