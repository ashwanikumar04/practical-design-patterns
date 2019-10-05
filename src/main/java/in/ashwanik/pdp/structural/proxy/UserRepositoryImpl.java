package in.ashwanik.pdp.structural.proxy;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final DatabaseConnection connection;

    public UserRepositoryImpl() {
        this.connection = DbConnectionPool.newConnection();
    }

    @Override
    public List<User> getUsers() {
        return connection.getList("select * from users", User.class);
    }

    @Override
    public User getUser(long id) {
        return connection.get(String.format("select * from users where id = %d", id), User.class);
    }
}
