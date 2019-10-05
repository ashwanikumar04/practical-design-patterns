package in.ashwanik.pdp.structural.proxy;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    User getUser(long id);
}
