package kulav.babylog.models.dto;

import kulav.babylog.models.Activity;
import kulav.babylog.models.TypeActivityRecord;
import lombok.Data;

@Data
public class ActivityDTO implements DTO {

	private long id;

	private String name;

	private String printName;

	private String img;
	
	private TypeActivityRecord type;
	
	public static ActivityDTO create(Activity a) {
		ActivityDTO dto = new ActivityDTO();
		dto.setId(a.getId());
		dto.setImg(a.getImg());
		dto.setName(a.getName());
		dto.setPrintName(a.getPrintName());
		dto.setType(a.getType());
		return dto;
	}
}
