package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    User getUserCar(String model, int series);

    List<User> listUsers();


}
