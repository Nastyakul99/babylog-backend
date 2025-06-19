package kulav.babylog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode(of = "id")
@ToString
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String printName;
	
	@Getter
	@Setter
	private String img;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="group_id")
	private ActivityGroup group;

}
