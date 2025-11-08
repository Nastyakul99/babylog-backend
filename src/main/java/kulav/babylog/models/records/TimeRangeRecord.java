package kulav.babylog.models.records;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import kulav.babylog.models.Activity;
import kulav.babylog.models.Baby;
import kulav.babylog.models.Person;
import kulav.babylog.models.dto.records.TimeRangeRecordDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TimeRangeRecord extends ActivityRecord {

	@Getter
	@Setter
	protected OffsetDateTime  endTime;
	
	public TimeRangeRecord update(TimeRangeRecordDTO dto, Activity activity, Baby baby, Person author) {
		this.startTime = dto.getStartTime();
		this.activity = activity;
		this.endTime = dto.getEndTime();
		this.baby = baby;
		this.author = author;
		return this;
	}
}
