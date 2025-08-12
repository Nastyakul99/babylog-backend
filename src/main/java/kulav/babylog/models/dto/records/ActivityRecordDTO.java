package kulav.babylog.models.dto.records;

import java.time.LocalDateTime;
import kulav.babylog.models.dto.DTO;
import kulav.babylog.models.records.ActivityRecord;
import lombok.Data;

@Data
public class ActivityRecordDTO implements DTO {
	
	protected long activityId;
	protected LocalDateTime startTime;
	
	public static ActivityRecordDTO create(ActivityRecord ar) {
		ActivityRecordDTO dto = new ActivityRecordDTO();
		dto.activityId = ar.getActivity() != null ? ar.getActivity().getId() : null;
		dto.startTime = ar.getStartTime();
		return dto;
	}

}
