package kulav.babylog.models.metadata;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kulav.babylog.models.Activity;
import kulav.babylog.models.DBEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ActivityMetadata implements DBEntity {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="activity_id")
	protected Activity activity;
	
	@Getter
	@Setter
	private String color;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private StatisticType statisticType;
	
	public ActivityMetadata() {
		
	}
	
	public ActivityMetadata(Activity activity, String color, String name, StatisticType statisticType) {
		this.activity = activity;
		this.color = color;
		this.name = name;
		this.statisticType = statisticType;
	}
}
