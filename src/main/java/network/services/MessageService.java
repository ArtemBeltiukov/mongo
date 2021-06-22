package network.services;

import network.entity.Message;
import network.entity.Model;
import network.entity.User;
import network.repository.message.MessageRepository;
import network.repository.message.MessageRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class MessageService implements DataManageService<Message> {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageRepositoryCustom messageRepositoryCustom;

    @Override
    public Message create(Message model) {
        return messageRepositoryCustom.createMessage(model);
    }

    @Override
    public Message read(BigInteger id) {
        return messageRepository.getById(id);
    }

    public List<Message> readAllByFromAndTo(User from, User to) {
        return messageRepository.findByFromAndTo(from, to);
    }

    @Override
    public void update(Message model) {

    }

    @Override
    public void delete(Message model) {
        messageRepository.delete(model);
    }
}
