package in.ashwanik.pdp.proxy;

import java.util.List;

public class UserRepositoryImplProxy implements UserRepository {

    private UserRepositoryImpl userRepository;

    @Override
    public List<User> getUsers() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository.getUsers();
    }

    @Override
    public User getUser(long id) {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository.getUser(id);
    }
}
