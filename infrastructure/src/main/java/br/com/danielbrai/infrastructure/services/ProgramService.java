package br.com.danielbrai.infrastructure.services;

import br.com.danielbrai.infrastructure.repositories.ProgramRepository;
import br.com.danielbrai.core.models.Program;
import br.com.danielbrai.core.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramService {

    private final ProgramRepository repository;

    public Program getProgramByGymMember(User gymMember) {
        return this.repository.getProgramByMember(gymMember);
    }
}
