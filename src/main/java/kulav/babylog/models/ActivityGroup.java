package kulav.babylog.models;

import java.util.ArrayList;
import java.util.List;

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
public class ActivityGroup {
	
	@Getter
	@Setter
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
	
	@OneToMany(mappedBy="group", cascade = CascadeType.ALL)
	private List<Activity> activities = new ArrayList<>();
	
	public ActivityGroup() {
		
	}
	
	public ActivityGroup(String name, String printName, String img) {
		this.name = name;
		this.printName = printName;
		this.img = img;
	}

}
