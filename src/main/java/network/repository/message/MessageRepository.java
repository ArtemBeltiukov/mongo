package network.repository.message;

import network.entity.Message;
import network.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, BigInteger> {

    Message getById(BigInteger id);

    List<Message> getByTo(User to);

    List<Message> getByFrom(User from);

    List<Message> findAll();

    List<Message> findByFromAndTo(User from, User to);

}
