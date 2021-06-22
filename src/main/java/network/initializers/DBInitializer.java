package network.initializers;

import network.entity.Message;
import network.entity.User;
import network.repository.message.MessageRepository;
import network.repository.user.UserRepository;
import network.services.DataManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DBInitializer {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataManageService<User> userService;

    @Autowired
    private DataManageService<Message> messageService;

    @Autowired
    private MessageRepository messageRepository;

    @Scheduled(fixedDelay = 300000)
    public void delete() {
        List<Message> messages = messageRepository.findAll();
        if (!messages.isEmpty())
            messageService.delete(messages.get(0));
    }
}
