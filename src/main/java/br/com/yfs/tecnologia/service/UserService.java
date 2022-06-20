package br.com.yfs.tecnologia.service;

import br.com.yfs.tecnologia.model.User;
import org.springframework.data.domain.Page;


public interface UserService {

    void saveUser(User user);

    User findById(Long id);

    Page<User> findAll();

    void deleteUserById(Long id);

    void updateUser(User user);

    Page<User> findByFirstName(String fullName);

    Page<User> findByEmail(String email);





}
