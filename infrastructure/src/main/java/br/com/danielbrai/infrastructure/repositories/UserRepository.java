package br.com.danielbrai.infrastructure.repositories;

import br.com.danielbrai.core.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User getMemberById(Long gymMemberId) {
        return User.builder()
                .name("Godofredo Josinaldo")
                .id(gymMemberId)
                .build();
    }
}
