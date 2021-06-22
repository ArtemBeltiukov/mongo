package network.controller;

import network.entity.Message;
import network.entity.MessagesCount;
import network.entity.User;
import network.services.MessageService;
import network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam String from, @RequestParam String to, @RequestParam String text) {
        User userFrom = userService.readByName(from);
        User userTo = userService.readByName(to);
        StringBuilder stringBuilder = new StringBuilder();

        if (userFrom == null) {
            stringBuilder.append("there is no user with name " + from + "\n");
            userFrom = new User(from);
            userService.create(userFrom);
            stringBuilder.append(from + " added" + "\n");
        }
        if (userTo == null) {
            stringBuilder.append("there is no user with name " + to + "\n");
            userTo = new User(to);
            userService.create(userTo);
            stringBuilder.append(to + " added" + "\n");
        }
        Message message = messageService.create(new Message(text, userFrom, userTo));
        stringBuilder.append("message \"" + text + "\" send from " + from + " to " + to + " successfully");
        return stringBuilder.toString();
    }

    @ResponseBody
    @GetMapping("/getChat")
    public String getChat(@RequestParam String from, @RequestParam String to) {
        User userFrom = userService.readByName(from);
        User userTo = userService.readByName(to);
        StringBuilder stringBuilder = new StringBuilder();

        if (userFrom == null) {
            return "there is no user with name " + from;
        }
        if (userTo == null) {
            return "there is no user with name " + to;
        }
        List<Message> messages = messageService.readAllByFromAndTo(userFrom, userTo);
        messages.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    @ResponseBody
    @GetMapping("/getAvgAge")
    public String getAvgAge() {
        return "average age is " + userService.getAvgAge();
    }

    @ResponseBody
    @GetMapping("/getUserWithMaxMessages")
    public String getUserWithMaxMessages() {
        MessagesCount messagesCount = userService.getUserWithMaxMessages();
        if (messagesCount == null)
            return "there is no user with max messages";

        return messagesCount.toString();
    }
}
