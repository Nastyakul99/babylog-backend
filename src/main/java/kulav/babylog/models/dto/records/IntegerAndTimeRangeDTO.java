package kulav.babylog.models.dto.records;

import kulav.babylog.models.records.IntegerAndTimeRange;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IntegerAndTimeRangeDTO extends TimeRangeRecordDTO {

	private Integer val;
	
    public static IntegerAndTimeRangeDTO create(IntegerAndTimeRange ar) {
    	IntegerAndTimeRangeDTO dto = baseCreate(ar, new IntegerAndTimeRangeDTO());
        dto.val = ar.getVal();
        return dto;
    }
}

