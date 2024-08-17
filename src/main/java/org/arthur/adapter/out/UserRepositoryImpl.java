package org.arthur.adapter.out;

import lombok.RequiredArgsConstructor;
import org.arthur.domain.CreateUserRequest;
import org.arthur.domain.User;
import org.arthur.port.out.UserRepository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final DataSource dataSource;

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, email) VALUES (?, ?)";

    @Override
    public User create(CreateUserRequest request) {

        try {
            var conn = dataSource.getConnection();
            var preparedStatement = conn.prepareStatement(INSERT_USER_SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, request.username());
            preparedStatement.setString(2, request.email());

            int affectedRecords = preparedStatement.executeUpdate();

            if (affectedRecords <= 0) {
                throw new RuntimeException("Error doing insert");
            }

            var resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                var id = preparedStatement.getGeneratedKeys().getLong(1);
                return new User(id, request.username(), request.email());
            }
            throw new RuntimeException();
        } catch (Exception e) { // TODO: do more specific
            throw new RuntimeException(e.getMessage()); // TODO: change also this
        }
    }
}
