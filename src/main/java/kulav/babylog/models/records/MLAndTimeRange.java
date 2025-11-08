package kulav.babylog.models.records;

import jakarta.persistence.Entity;
import kulav.babylog.models.Activity;
import kulav.babylog.models.Baby;
import kulav.babylog.models.Person;
import kulav.babylog.models.dto.records.MLAndTimeRangeDTO;

@Entity
public class MLAndTimeRange extends IntegerAndTimeRange {

	public MLAndTimeRange update(MLAndTimeRangeDTO dto, Activity activity, Baby baby, Person author) {
		this.startTime = dto.getStartTime();
		this.endTime = dto.getEndTime();
		this.activity = activity;
		this.val = dto.getVal();
		this.baby = baby;
		this.author = author;
		return this;
	}
}
