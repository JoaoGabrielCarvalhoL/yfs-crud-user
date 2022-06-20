package br.com.yfs.tecnologia.application.model;


import br.com.yfs.tecnologia.model.User;
import br.com.yfs.tecnologia.model.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Test
    public void should_create_user() {

        User user = User.builder().
                fullName("João Gabriel Carvalho")
                .email("27.joaogabriel@gmail.com");
        Assertions.assertNotNull(user);
        System.out.println(user);
    }

    @Test
    public void should_create_user_builder() {

        User user = UserBuilder.builder().
                fullName("João Gabriel").
                email("27.joaogabriel@gmail.com").build();
        Assertions.assertNotNull(user);
        System.out.println(user.getFullName() + " " + user.getEmail());
    }
}
