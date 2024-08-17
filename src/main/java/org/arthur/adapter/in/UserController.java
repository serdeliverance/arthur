package org.arthur.adapter.in;

import io.javalin.http.Context;
import lombok.RequiredArgsConstructor;
import org.arthur.domain.CreateUserRequest;
import org.arthur.domain.User;
import org.arthur.usecase.CreateUserUseCase;

@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public void create(Context ctx) {
        var request = ctx.bodyAsClass(CreateUserRequest.class);
        System.out.println(request);
        var result = createUserUseCase.createUser(request);
        ctx.json(result, User.class);
        ctx.status(201);
    }
}
