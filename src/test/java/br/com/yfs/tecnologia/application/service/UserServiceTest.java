package br.com.yfs.tecnologia.application.service;

import br.com.yfs.tecnologia.exception.NotFoundException;
import br.com.yfs.tecnologia.model.Address;
import br.com.yfs.tecnologia.model.Contact;
import br.com.yfs.tecnologia.model.User;
import br.com.yfs.tecnologia.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void should_save_user() {
        User user = new User();
        user.setFirstName("Joao Teste");
        user.setLastName("Carvalho");
        user.setEmail("27.joaogabriel@gmail.com");
        user.setContact(new Contact("14 998045007","14 33791173"));
        user.setAddress(new Address("Eduardo Martins Romeira", "Jardim Planalto", "302", "19930000"));
        userService.saveUser(user);
    }

    @Test
    public void should_find_by_id() {
        User userResult = userService.findById(8L);
        System.out.println(userResult);
        Assertions.assertNotNull(userResult);
    }

    @Test
    public void should_update_user() {
        User userUpdated = new User();
        userUpdated.setFirstName("Joao Teste");
        userUpdated.setLastName("Carvalho Teste Teste");
        userUpdated.setEmail("27.joaogabriel@gmail.com");
        userUpdated.setContact(new Contact("14 998045007","14 33791173"));
        userUpdated.setAddress(new Address("Eduardo Martins Romeira", "Jardim Planalto", "302", "19930000"));
        userService.updateUser(8L, userUpdated);
        System.out.println(userUpdated);
    }

    @Test
    public void should_find_all_user() {
        List<User> userList = new ArrayList<User>();
        userList = userService.findAll();
        userList.forEach(u -> System.out.println(u));
        Assertions.assertNotNull(userList);
    }

    @Test()
    public void should_delete_user() {
        userService.deleteUserById(8L);
        Assertions.assertThrows(NotFoundException.class, () -> userService.findById(4L));
    }

    @Test
    public void should_return_user_by_first_name() {
        List<User> result = userService.findByFirstName("Joao");
        Assertions.assertNotNull(result);
    }

    @Test
    public void should_return_user_by_email() {
        List<User> result = userService.findByEmail("joaogabriel");
        Assertions.assertNotNull(result);
    }
}
