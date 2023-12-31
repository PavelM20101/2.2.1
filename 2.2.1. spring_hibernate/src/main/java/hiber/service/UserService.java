package hiber.service;

import hiber.dao.CarDAO;
import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User find(String model, int series);
}
