package org.arthur.port.out;

import org.arthur.domain.CreateUserRequest;
import org.arthur.domain.User;

public interface UserRepository {

    User create(CreateUserRequest request);
}
