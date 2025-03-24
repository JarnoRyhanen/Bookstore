package home.jarnobookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import home.jarnobookstore.domain.AppUser;
import home.jarnobookstore.domain.AppUserRepository;

@SpringBootTest(classes = JarnobookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    public void createNewUser() {
        AppUser user = new AppUser("Test user", "test.user@email.com", "abc", "USER");
        appUserRepository.save(user);
        assertThat(user).isNotNull();
    }

    @Test
    public void findUserByUsername() {
        AppUser user = appUserRepository.findByUsername("Test user");
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("Test user");
    }

    @Test
    public void deleteUserByUserName() {
        AppUser user = appUserRepository.findByUsername("Test user");
        appUserRepository.delete(user);

        AppUser deletedUser = appUserRepository.findByUsername("Test user");
        assertThat(deletedUser).isNull();
    }
}
