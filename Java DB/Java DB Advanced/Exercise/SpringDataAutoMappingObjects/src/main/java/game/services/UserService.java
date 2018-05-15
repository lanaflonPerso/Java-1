package game.services;

import game.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(long id);

    User createOne(User user);

    List<User> createMany(Iterable<User> users);

    User updateOne(User user);

    List<User> updateMany(Iterable<User> users);

    void deleteById(long id);

    User findUserByCredentials(String email, String password);

    User findUserByLoggedInIsTrue();

    User findUserByLoggedInIsTrueWithGames();

    User getUserIfLoggedInAndAdmin();
}
