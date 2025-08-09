package kulav.babylog.models.dto.records;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextNoteRecordDTO extends ActivityRecordDTO {

	private String comment;
}
