package kulav.babylog.models.dto;

import kulav.babylog.models.ActivityGroup;
import lombok.Data;

@Data
public class ActivityGroupDTO implements DTO {
	
	private long id;

	private String name;

	private String printName;

	private String img;
	
	public static ActivityGroupDTO create(ActivityGroup g) {
		ActivityGroupDTO dto = new ActivityGroupDTO();
		dto.setId(g.getId());
		dto.setName(g.getName());
		dto.setPrintName(g.getPrintName());
		dto.setImg(g.getImg());
		return dto;
	}
}
