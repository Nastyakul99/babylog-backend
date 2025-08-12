package kulav.babylog.models.records;

import jakarta.persistence.Entity;
import kulav.babylog.models.Activity;
import kulav.babylog.models.dto.records.TextNoteRecordDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TextNoteRecord extends ActivityRecord {

	@Getter
	@Setter
	private String comment;
	
	public TextNoteRecord update(TextNoteRecordDTO dto, Activity activity) {
		this.startTime = dto.getStartTime();
		this.activity = activity;
		this.comment = dto.getComment();
		return this;
	}
}
