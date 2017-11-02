package microbank.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance
@Table(name = "contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner_id")
	private Client owner;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contant_id")
	private Client contact;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	public Client getContact() {
		return contact;
	}

	public void setContact(Client contact) {
		this.contact = contact;
	}

	
}
