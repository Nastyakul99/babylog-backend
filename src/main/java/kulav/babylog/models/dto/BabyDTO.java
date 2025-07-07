package kulav.babylog.models.dto;

import java.time.LocalDate;
import kulav.babylog.models.Baby;
import kulav.babylog.models.Gender;
import lombok.Data;

@Data
public class BabyDTO {

	private long id;
	
	private String name;

	private LocalDate birthDate;

	private Gender gender;
	
	public static BabyDTO create(Baby b) {
		BabyDTO dto = new BabyDTO();
		dto.id = b.getId();
		dto.name = b.getName();
		dto.birthDate = b.getBirthDate();
		dto.gender = b.getGender();
		return dto;
	}
}
