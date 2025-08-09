package kulav.babylog.models.records;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TextNoteRecord extends ActivityRecord {

	@Getter
	@Setter
	private String comment;
}
