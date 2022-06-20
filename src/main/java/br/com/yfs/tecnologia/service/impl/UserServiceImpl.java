package br.com.yfs.tecnologia.service.impl;

import br.com.yfs.tecnologia.exception.NotFoundException;
import br.com.yfs.tecnologia.model.User;
import br.com.yfs.tecnologia.repository.UserRepository;
import br.com.yfs.tecnologia.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        Optional<User> userResult = userRepository.findById(id);
        return userResult.orElseThrow(() -> new NotFoundException("User not found! Id: " + id));
    }

    @Override
    public Page<User> findAll() {
        int page = 0;
        int size = 20;
        PageRequest pageRequest = PageRequest.of(page, size);
        return new PageImpl<>(userRepository.findAll(), pageRequest, size);
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> userResult = userRepository.findById(id);
        if (userResult.isEmpty()) {
            throw new NotFoundException("User not found! Id: " + id);
        }
        userRepository.delete(userResult.get());
    }

    @Override
    public void updateUser(User user) {
        saveUser(user);

    }

    @Override
    public Page<User> findByFirstName(String fullName) {
        int page = 0;
        int size = 20;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "fullName");
        return userRepository.findUserByName(fullName, pageRequest);
    }

    @Override
    public Page<User> findByEmail(String email) {
        int page = 0;
        int size = 20;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "email");
        return userRepository.findUserByEmail(email, pageRequest);
    }

}
