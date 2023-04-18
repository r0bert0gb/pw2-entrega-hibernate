package pw2.roberto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Channel extends PanacheEntity {

    private String hash;

    @ManyToMany(mappedBy = "channels")
    private List<User> users;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "channel_id")
    private List<Message> messages;

    public Channel() {
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

}
