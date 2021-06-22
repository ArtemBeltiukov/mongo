package network.repository.user;

import network.entity.User;

public interface UserRepositoryCustom {
    User createUser(User user);

    double getAvgAge();
}
