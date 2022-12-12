package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.User;
import ru.catering.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Long createUser(User userFromClient) {
        User user = new User();
        user.setName(userFromClient.getName());
        user.setLastName(userFromClient.getLastName());
        user.setPatronymic(userFromClient.getPatronymic());
        user.setLogin(userFromClient.getLogin());
        user.setPassword(userFromClient.getPassword());
        user.setRole(userFromClient.getRole());
        user.setMail(userFromClient.getMail());
//        user.setDeleted(false);
        return userRepository.save(user).getId();
    }

    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    public void deleteUser(Long id) {
        User user = userRepository.getById(id);
        user.setDeleted(true);
        userRepository.save(user);
    }
}