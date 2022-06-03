package br.com.yfs.tecnologia.service;

import br.com.yfs.tecnologia.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    User findById(Long id);
    List<User> findAll();
    void deleteUserById(Long id);
    void updateUser(Long id, User user);
    List<User> findByFirstName(String firstName);
    List<User> findByEmail(String email);





}
