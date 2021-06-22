package network.services;

import network.entity.MessagesCount;
import network.entity.User;
import network.repository.message.MessageRepositoryCustom;
import network.repository.user.UserRepository;
import network.repository.user.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserService implements DataManageService<User> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    @Autowired
    private MessageRepositoryCustom messageRepositoryCustom;

    @Override
    public User create(User model) {
        model.setAge(ThreadLocalRandom.current().nextInt(0, 99));
        return userRepositoryCustom.createUser(model);
    }

    @Override
    public User read(BigInteger id) {
        return userRepository.getById(id);
    }

    public User readByName(String name) {
        return userRepository.getByName(name);
    }

    public MessagesCount getUserWithMaxMessages() {
        return messageRepositoryCustom.getUserWithMaxMessages();
    }

    public double getAvgAge() {
        return userRepositoryCustom.getAvgAge();
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(User model) {
        userRepository.delete(model);
    }
}
