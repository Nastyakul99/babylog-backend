package kulav.babylog.models.dto.records;

import kulav.babylog.models.records.TextNoteRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextNoteRecordDTO extends ActivityRecordDTO {

	private String comment;
	
    public static TextNoteRecordDTO create(TextNoteRecord ar) {
        TextNoteRecordDTO dto = baseCreate(ar, new TextNoteRecordDTO());
        dto.comment = ar.getComment();
        return dto;
    }
}
