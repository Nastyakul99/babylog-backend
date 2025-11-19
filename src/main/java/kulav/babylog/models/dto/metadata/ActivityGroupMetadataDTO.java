package kulav.babylog.models.dto.metadata;

import kulav.babylog.models.dto.DTO;
import kulav.babylog.models.metadata.ActivityGroupMetadata;
import lombok.Data;

@Data
public class ActivityGroupMetadataDTO implements DTO {

	private long id;
	
	private long activityGroupId;
	
	public static ActivityGroupMetadataDTO create(ActivityGroupMetadata b) {
		ActivityGroupMetadataDTO dto = new ActivityGroupMetadataDTO();
		dto.id = b.getId();
		dto.activityGroupId = b.getActivityGroup().getId();
		return dto;
	}
}
