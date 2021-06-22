package network.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Document(collection = "messages")
public class Message implements Model {
    @Id
    private BigInteger id;
    @Field(value = "text")
    private String text;
    @Field
    private User from;
    @Field
    private User to;

    public Message(String text, User from, User to) {
        this.text = text;
        this.from = from;
        this.to = to;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
