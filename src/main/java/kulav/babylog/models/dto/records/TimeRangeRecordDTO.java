package kulav.babylog.models.dto.records;

import java.time.OffsetDateTime;
import kulav.babylog.models.records.TimeRangeRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeRangeRecordDTO extends ActivityRecordDTO {
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
	protected OffsetDateTime endTime;
	
    public static TimeRangeRecordDTO create(TimeRangeRecord ar) {
        TimeRangeRecordDTO dto = baseCreate(ar, new TimeRangeRecordDTO());
        dto.endTime = ar.getEndTime();
        return dto;
    }
}
