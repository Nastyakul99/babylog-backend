package kulav.babylog.models.records;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kulav.babylog.models.Activity;
import kulav.babylog.models.dto.records.ActivityRecordDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode(of = "id")
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class ActivityRecord {
	
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
	protected LocalDateTime startTime;
	
	public ActivityRecord update(ActivityRecordDTO dto, Activity activity) {
		this.startTime = dto.getStartTime();
		this.activity = activity;
		return this;
	}
}
