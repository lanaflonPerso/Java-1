package student.system.services;

import student.system.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(long id);

    User createOne(User user);

    List<User> createMany(Iterable<User> users);

    User updateOne(User user);

    List<User> updateMany(Iterable<User> users);

    void deleteById(long id);

    List<User> findDeletedUsers();
}
