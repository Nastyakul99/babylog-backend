package kulav.babylog.models.records;

import jakarta.persistence.Entity;
import kulav.babylog.models.Activity;
import kulav.babylog.models.Baby;
import kulav.babylog.models.Person;
import kulav.babylog.models.dto.records.TextNoteRecordDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TextNoteRecord extends TimeRangeRecord {

	@Getter
	@Setter
	private String comment;
	
	public TextNoteRecord update(TextNoteRecordDTO dto, Activity activity, Baby baby, Person author) {
		this.startTime = dto.getStartTime();
		this.endTime = dto.getEndTime();
		this.activity = activity;
		this.comment = dto.getComment();
		this.baby = baby;
		this.author = author;
		return this;
	}
}
