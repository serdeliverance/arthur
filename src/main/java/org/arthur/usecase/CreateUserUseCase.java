package org.arthur.usecase;

import org.arthur.domain.CreateUserRequest;
import org.arthur.domain.User;

public interface CreateUserUseCase {

    User createUser(CreateUserRequest request);

}
