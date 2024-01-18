package by.itclass.model.services;

import by.itclass.model.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void deleteById(int userId);
    void add(User user);
    void update(User user);

}
