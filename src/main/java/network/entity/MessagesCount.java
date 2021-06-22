package network.entity;

import org.springframework.data.annotation.Id;

public class MessagesCount {
    @Id
    private User user;
    private int total;

    public MessagesCount() {
    }

    public MessagesCount(User user, int total) {
        this.user = user;
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "MessagesCount{" +
                "user=" + user +
                ", total=" + total +
                '}';
    }
}
