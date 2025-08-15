package kulav.babylog.models.dto.records;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kulav.babylog.models.dto.DTO;
import kulav.babylog.models.records.ActivityRecord;
import lombok.Data;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type"
	)
	@JsonSubTypes({
		@JsonSubTypes.Type(value = ActivityRecordDTO.class, name = "BASE_RECORD"),
	    @JsonSubTypes.Type(value = TextNoteRecordDTO.class, name = "TEXT_NOTE"),
	    @JsonSubTypes.Type(value = TimeRangeRecordDTO.class, name = "TIME_RANGE")
	})
@Data
public class ActivityRecordDTO implements DTO {
	
	protected long id;
	protected long babyId;
	protected long activityId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	protected LocalDateTime startTime;
	
    protected static <T extends ActivityRecordDTO> T baseCreate(ActivityRecord ar, T dto) {
    	dto.babyId = ar.getBaby() != null ? ar.getBaby().getId() : null;
        dto.id = ar.getId();
        dto.activityId = ar.getActivity() != null ? ar.getActivity().getId() : null;
        dto.startTime = ar.getStartTime();
        return dto;
    }

    public static ActivityRecordDTO create(ActivityRecord ar) {
        return baseCreate(ar, new ActivityRecordDTO());
    }
}
