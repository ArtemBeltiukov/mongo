package network.repository.message;

import network.entity.Message;
import network.entity.MessagesCount;

public interface MessageRepositoryCustom {

    Message createMessage(Message message);

    MessagesCount getUserWithMaxMessages();
}
