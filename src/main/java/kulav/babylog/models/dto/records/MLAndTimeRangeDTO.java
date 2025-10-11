package kulav.babylog.models.dto.records;

import kulav.babylog.models.records.MLAndTimeRange;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MLAndTimeRangeDTO extends IntegerAndTimeRangeDTO {

    public static MLAndTimeRangeDTO create(MLAndTimeRange ar) {
    	MLAndTimeRangeDTO dto = baseCreate(ar, new MLAndTimeRangeDTO());
        dto.val = ar.getVal();
        return dto;
    }
}
