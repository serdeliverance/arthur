package org.arthur;

import io.javalin.Javalin;
import org.arthur.adapter.in.UserController;
import org.arthur.adapter.out.UserRepositoryImpl;
import org.arthur.config.DataSourceConfig;
import org.arthur.usecase.CreateUserUseCaseImpl;

public class Arthur {
  public static void main(String[] args) {
    var connUrl = System.getenv("DB_URL");
    var username = System.getenv("DB_USERNAME");
    var password = System.getenv("DB_PASSWORD");
    var dataSource = DataSourceConfig.getDataSource(connUrl, username, password);
    var userRepository = new UserRepositoryImpl(dataSource);
    var createUserUseCase = new CreateUserUseCaseImpl(userRepository);
    var userController = new UserController(createUserUseCase);


    Javalin.create().post("/users", userController::create)
            .start();
  }
}
