package by.itclass.model.services;

import by.itclass.model.entities.User;

import java.util.List;

public interface UserService {
    //метод который будет возвращать лист (всех) user
    List<User> getAllUsers();  // получает
}
