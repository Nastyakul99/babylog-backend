package kulav.babylog.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode(of = "id")
@ToString
public class Family {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Getter
	@Setter
	private String name;

	@JsonIgnore
	@Getter
	@Setter
	@OneToMany(mappedBy="family", cascade = CascadeType.ALL)
	private List<Person> persons = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="family", cascade = CascadeType.ALL)
	private List<Baby> babies = new ArrayList<>();
	
	public void addPerson(Person p) {
		p.setFamily(this);
		persons.add(p);
	}
	
	public void deletePerson(Person p) {
		p.setFamily(null);
		persons.remove(p);
	}
}
