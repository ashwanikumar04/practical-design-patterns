package in.ashwanik.pdp.structural.proxy;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserRepositoryUnitTest {
    @Test
    public void testUserRepository() {
        UserRepository userRepository = new UserRepositoryImplProxy();
        assertThat(userRepository.getUsers().size()).isEqualTo(0);
    }
}
