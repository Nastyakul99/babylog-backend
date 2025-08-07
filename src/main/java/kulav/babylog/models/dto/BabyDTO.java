package kulav.babylog.models.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import kulav.babylog.models.Baby;
import kulav.babylog.models.Gender;
import kulav.babylog.utils.StringMapper;
import lombok.Data;

@Data
public class BabyDTO implements DTO {

	private long id;
	
	private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
	
	public String toString() {
		return StringMapper.map(this);
	}
}
