package kulav.babylog.models.dto;

import java.time.LocalDateTime;

public record CreateActivityRecordRequest(Long activityId, LocalDateTime startTime,
		LocalDateTime endTime, String comment) {


}
