package kulav.babylog.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;
	
	@Getter
	@Setter
	private long vkId;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="family_id")
	private Family family;
	
	public Person() {
		
	}
	
	public Person(long vkId) {
		this.vkId = vkId;
	}
	
	public void removeFromFamily() {
		if(family != null) {
			family.deletePerson(this);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(vkId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return vkId == other.vkId;
	}
}
