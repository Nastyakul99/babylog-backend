package kulav.babylog.models;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode(of = "id")
@ToString
public class Activity {
	
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
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="group_id")
	private ActivityGroup group;
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private TypeActivityRecord type;
	
	@Getter
	@JsonIgnore
	@OneToMany(mappedBy="activity", cascade = CascadeType.ALL)
	private List<ActivityRecord> records = new ArrayList<>();
	
	public Activity() {
		
	}
	
	public Activity(String name, String printName, String img, ActivityGroup group) {
		this.name = name;
		this.printName = printName;
		this.img = img;
		this.group = group;
	}

}
