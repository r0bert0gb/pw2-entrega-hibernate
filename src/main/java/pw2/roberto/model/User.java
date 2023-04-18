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
public class User extends PanacheEntity {

	private String name;
	private String hash;

	@JsonBackReference
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Channel> channels;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Message> messages;

	public User() {

		this.channels = new ArrayList<>();
		this.messages = new ArrayList<>();
	}

	public void addChannel(Channel channel) {

		this.channels.add(channel);
	}
	public void addMessage(Message message) {

		this.messages.add(message);
	}
}
