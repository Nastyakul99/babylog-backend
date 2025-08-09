package kulav.babylog.models.dto.records;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeRangeRecordDTO extends ActivityRecordDTO {

	private LocalDateTime endTime;
}
