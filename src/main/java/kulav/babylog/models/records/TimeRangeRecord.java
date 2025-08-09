package kulav.babylog.models.records;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TimeRangeRecord extends ActivityRecord {

	@Getter
	@Setter
	private LocalDateTime endTime;
}
