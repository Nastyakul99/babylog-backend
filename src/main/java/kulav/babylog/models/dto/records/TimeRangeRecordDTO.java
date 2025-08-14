package kulav.babylog.models.dto.records;

import java.time.LocalDateTime;

import kulav.babylog.models.records.TimeRangeRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeRangeRecordDTO extends ActivityRecordDTO {

	private LocalDateTime endTime;
	
    public static TimeRangeRecordDTO create(TimeRangeRecord ar) {
        TimeRangeRecordDTO dto = baseCreate(ar, new TimeRangeRecordDTO());
        dto.endTime = ar.getEndTime();
        return dto;
    }
}
