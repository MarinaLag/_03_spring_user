package by.itclass.model.dao;

import by.itclass.model.entities.User;

import java.util.List;

public interface UserDao {
     //метод который будет возвращать лист (всех) user
     List<User> selectAllUsers();  // обращается к БД
}
