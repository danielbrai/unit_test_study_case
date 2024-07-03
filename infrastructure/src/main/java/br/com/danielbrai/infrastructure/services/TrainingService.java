package br.com.danielbrai.infrastructure.services;

import br.com.danielbrai.core.models.Program;
import br.com.danielbrai.core.models.TrainingRun;
import br.com.danielbrai.core.models.User;
import br.com.danielbrai.infrastructure.repositories.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final ProgramService programService;
    private final UserService userService;

    public TrainingRun startTraining(Long gymMemberId) {
        User gymMember = this.userService.getUserMemberById(gymMemberId);
        Program programByGymMember = this.programService.getProgramByGymMember(gymMember);
        TrainingRun trainingRun = new TrainingRun();
        trainingRun.startTraining(programByGymMember);
        trainingRun.setId(1L);
        return trainingRun;
    }

    public TrainingRun increaseCount(Long trainingId) {
        TrainingRun training = TrainingRepository.getTrainingById(trainingId);
        training.addExecutionToCurrentExercise();
        return training;
    }
}
