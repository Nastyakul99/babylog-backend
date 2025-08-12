package kulav.babylog.models.records;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import kulav.babylog.models.Activity;
import kulav.babylog.models.dto.records.TimeRangeRecordDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TimeRangeRecord extends ActivityRecord {

	@Getter
	@Setter
	private LocalDateTime endTime;
	
	public TimeRangeRecord update(TimeRangeRecordDTO dto, Activity activity) {
		this.startTime = dto.getStartTime();
		this.activity = activity;
		this.endTime = dto.getEndTime();
		return this;
	}
}
