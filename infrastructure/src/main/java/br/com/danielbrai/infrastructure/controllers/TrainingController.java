package br.com.danielbrai.infrastructure.controllers;

import br.com.danielbrai.core.models.ExerciseRun;
import br.com.danielbrai.core.models.TrainingRun;
import br.com.danielbrai.infrastructure.services.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @PostMapping
    public ResponseEntity<TrainingRun> startTraining(@RequestParam("gymMemberId") Long idMember) {
        TrainingRun trainingRun = this.trainingService.startTraining(idMember);
        return ResponseEntity.ok().body(trainingRun);
    }

    @PatchMapping
    public ResponseEntity<TrainingRun> increaseCount(@RequestParam("training-id") Long trainingId) {
        TrainingRun trainingRun = this.trainingService.increaseCount(trainingId);
        return ResponseEntity.ok().body(trainingRun);
    }
}
