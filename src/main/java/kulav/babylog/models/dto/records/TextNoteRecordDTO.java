package kulav.babylog.models.dto.records;

import kulav.babylog.models.records.TextNoteRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextNoteRecordDTO extends ActivityRecordDTO {

	private String comment;
	
	public static TextNoteRecordDTO create(TextNoteRecord ar) {
		TextNoteRecordDTO dto = new TextNoteRecordDTO();
		dto.activityId = ar.getActivity() != null ? ar.getActivity().getId() : null;
		dto.startTime = ar.getStartTime();
		dto.comment = ar.getComment();
		return dto;
	}
}
