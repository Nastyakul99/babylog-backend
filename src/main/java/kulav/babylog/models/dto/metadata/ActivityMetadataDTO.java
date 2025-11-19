package kulav.babylog.models.dto.metadata;

import kulav.babylog.models.dto.DTO;
import kulav.babylog.models.metadata.ActivityMetadata;
import kulav.babylog.models.metadata.StatisticType;
import lombok.Data;

@Data
public class ActivityMetadataDTO implements DTO {

	private long id;
	
	protected long activityId;
	
	private String color;
	
	private String name;
	
	private StatisticType statisticType;
	
	private boolean isChart;
	
	public static ActivityMetadataDTO create(ActivityMetadata b) {
		ActivityMetadataDTO dto = new ActivityMetadataDTO();
		dto.id = b.getId();
		dto.activityId = b.getActivity().getId();
		dto.color = b.getColor();
		dto.name = b.getName();
		dto.statisticType = b.getStatisticType();
		dto.isChart = b.getStatisticType().isChart();
		return dto;
	}
}
