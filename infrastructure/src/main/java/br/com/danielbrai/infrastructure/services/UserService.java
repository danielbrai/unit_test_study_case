package br.com.danielbrai.infrastructure.services;

import br.com.danielbrai.infrastructure.repositories.UserRepository;
import br.com.danielbrai.core.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User getUserMemberById(Long gymMemberId) {
        return this.repository.getMemberById(gymMemberId);
    }
}
