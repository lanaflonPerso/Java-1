package bank.services;

import bank.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(long id);

    User create(User user);

    List<User> multipleCreate(Iterable<User> users);

    void deleteById(long id);

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByLoggedInIsTrue();
}
