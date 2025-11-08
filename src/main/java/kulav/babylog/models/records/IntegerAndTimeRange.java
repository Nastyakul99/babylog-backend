package kulav.babylog.models.records;

import jakarta.persistence.Entity;
import kulav.babylog.models.Activity;
import kulav.babylog.models.Baby;
import kulav.babylog.models.Person;
import kulav.babylog.models.dto.records.IntegerAndTimeRangeDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
public class IntegerAndTimeRange extends TimeRangeRecord {

	@Getter
	@Setter
	protected Integer val;
	
	public IntegerAndTimeRange update(IntegerAndTimeRangeDTO dto, Activity activity, Baby baby, Person author) {
		this.startTime = dto.getStartTime();
		this.endTime = dto.getEndTime();
		this.activity = activity;
		this.val = dto.getVal();
		this.baby = baby;
		this.author = author;
		return this;
	}
}
