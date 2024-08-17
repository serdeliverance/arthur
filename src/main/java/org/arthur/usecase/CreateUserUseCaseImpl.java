package org.arthur.usecase;

import lombok.RequiredArgsConstructor;
import org.arthur.domain.CreateUserRequest;
import org.arthur.domain.User;
import org.arthur.port.out.UserRepository;

@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserRequest request) {
        return userRepository.create(request);
    }
}
