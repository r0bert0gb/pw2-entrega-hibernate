package pw2.roberto.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message extends PanacheEntity {

	private String text;

	// TODO teste sem getter e setter de id

}
