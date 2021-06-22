package network.repository.user;

import network.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {

    User getById(BigInteger id);

    User getByName(String name);
}
