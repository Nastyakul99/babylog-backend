package kulav.babylog.models.metadata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kulav.babylog.models.ActivityGroup;
import kulav.babylog.models.DBEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ActivityGroupMetadata implements DBEntity {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="activity_group_id")
	protected ActivityGroup activityGroup;
	
	public ActivityGroupMetadata() {
		
	}
	
	public ActivityGroupMetadata(ActivityGroup activityGroup) {
		this.activityGroup = activityGroup;
	}
}
