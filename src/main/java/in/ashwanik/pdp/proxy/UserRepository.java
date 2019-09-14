package in.ashwanik.pdp.proxy;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    User getUser(long id);
}
