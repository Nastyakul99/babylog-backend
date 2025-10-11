package kulav.babylog.models.records;

import java.time.OffsetDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kulav.babylog.models.Activity;
import kulav.babylog.models.Baby;
import kulav.babylog.models.Updatable;
import kulav.babylog.models.dto.records.ActivityRecordDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ActivityRecord implements Updatable<ActivityRecord, ActivityRecordDTO> {
	
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
	@ManyToOne
	@JoinColumn(name="baby_id")
	protected Baby baby;
	
	@Getter
	@Setter
	protected OffsetDateTime  startTime;
	
	public ActivityRecord update(ActivityRecordDTO dto, Activity activity, Baby baby) {
		update(dto);
		this.activity = activity;
		this.baby = baby;
		return this;
	}

	@Override
	public ActivityRecord update(ActivityRecordDTO dto) {
		this.startTime = dto.getStartTime();
		return this;
	}

	@Override
	public String toString() {
		return "ActivityRecord [id=" + id + ", activity=" + activity + ", startTime=" + startTime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(activity, startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityRecord other = (ActivityRecord) obj;
		return Objects.equals(activity, other.activity) && Objects.equals(startTime, other.startTime);
	}
}
