package br.com.yfs.tecnologia.application.service;

import br.com.yfs.tecnologia.exception.NotFoundException;
import br.com.yfs.tecnologia.model.Address;
import br.com.yfs.tecnologia.model.User;
import br.com.yfs.tecnologia.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void should_save_user() {

    }

    @Test
    public void should_find_by_id() {

    }

    @Test
    public void should_update_user() {

    }

    @Test
    public void should_find_all_user() {
       /* List<User> userList = new ArrayList<User>();
        userList = userService.findAll();
        userList.forEach(u -> System.out.println(u));
        Assertions.assertNotNull(userList);
        */
    }

    @Test()
    public void should_delete_user() {
        /*userService.deleteUserById(8);
        Assertions.assertThrows(NotFoundException.class, () -> userService.findById(4));*/
    }

    @Test
    public void should_return_user_by_first_name() {
        Page<User> result = userService.findByFirstName("Joao");
        Assertions.assertNotNull(result);
    }

    @Test
    public void should_return_user_by_email() {
        Page<User> result = userService.findByEmail("joaogabriel");
        Assertions.assertNotNull(result);
    }
}
