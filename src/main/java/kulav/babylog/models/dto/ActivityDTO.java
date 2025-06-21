package kulav.babylog.models.dto;

import kulav.babylog.models.Activity;
import lombok.Data;

@Data
public class ActivityDTO {

	private long id;

	private String name;

	private String printName;

	private String img;
	
	public static ActivityDTO create(Activity a) {
		ActivityDTO dto = new ActivityDTO();
		dto.setId(a.getId());
		dto.setImg(a.getImg());
		dto.setName(a.getName());
		dto.setPrintName(a.getPrintName());
		return dto;
	}
}
