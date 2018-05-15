package student.system.services;

import student.system.entities.User;
import student.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public User createOne(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> createMany(Iterable<User> users) {
        return this.userRepository.save(users);
    }

    @Override
    public User updateOne(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> updateMany(Iterable<User> users) {
        return this.userRepository.save(users);
    }

    @Override
    public void deleteById(long id) {
        this.userRepository.delete(id);
    }

    @Override
    public List<User> findDeletedUsers() {
        return this.userRepository.findDeletedUsers();
    }

}
