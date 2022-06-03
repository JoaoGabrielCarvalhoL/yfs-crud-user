package br.com.yfs.tecnologia.service.impl;

import br.com.yfs.tecnologia.exception.NotFoundException;
import br.com.yfs.tecnologia.model.User;
import br.com.yfs.tecnologia.repository.UserRepository;
import br.com.yfs.tecnologia.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<User> findAll() {
        return userRepository.findAll();
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
    public void updateUser(Long id, User user) {
        Optional<User> userResult = userRepository.findById(id);
        if (userResult.isEmpty()) {
            throw new NotFoundException("User not found! Id: " + id);
        }
        userResult.get().setFirstName(user.getFirstName());
        userResult.get().setLastName(user.getLastName());
        userResult.get().setEmail(user.getEmail());
        userResult.get().setAddress(user.getAddress());
        userResult.get().setContact(user.getContact());
        userRepository.save(userResult.get());
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        List<User> users = userRepository.findAll();
        Stream<User> result = users.stream().filter(x -> x.getFirstName().contains(firstName));
        return result.collect(Collectors.toList());
    }

    @Override
    public List<User> findByEmail(String email) {
        List<User> users = userRepository.findAll();
        Stream<User> result = users.stream().filter(x -> x.getEmail().contains(email));
        return result.collect(Collectors.toList());
    }

}
