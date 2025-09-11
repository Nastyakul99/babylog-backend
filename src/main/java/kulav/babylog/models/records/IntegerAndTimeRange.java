package kulav.babylog.models.records;

import jakarta.persistence.Entity;
import kulav.babylog.models.Activity;
import kulav.babylog.models.Baby;
import kulav.babylog.models.dto.records.IntegerAndTimeRangeDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
public class IntegerAndTimeRange extends TimeRangeRecord {

	@Getter
	@Setter
	private Integer val;
	
	public IntegerAndTimeRange update(IntegerAndTimeRangeDTO dto, Activity activity, Baby baby) {
		this.startTime = dto.getStartTime();
		this.activity = activity;
		this.val = dto.getVal();
		this.baby = baby;
		return this;
	}
}
