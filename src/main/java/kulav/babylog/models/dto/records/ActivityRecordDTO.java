package kulav.babylog.models.dto.records;

import java.time.LocalDateTime;
import kulav.babylog.models.dto.DTO;
import lombok.Data;

@Data
public class ActivityRecordDTO implements DTO {
	
	private long activityId;
	private LocalDateTime startTime;

}
