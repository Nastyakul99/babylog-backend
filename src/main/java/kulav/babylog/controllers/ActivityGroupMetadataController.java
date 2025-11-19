package kulav.babylog.controllers;

import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kulav.babylog.models.dto.metadata.ActivityGroupMetadataDTO;
import kulav.babylog.services.ActivityGroupMetadataService;

@RestController
@RequestMapping({"/activityGroupMetadata"})
public class ActivityGroupMetadataController {

	private final ActivityGroupMetadataService activityGroupMetadataService;
	
	public ActivityGroupMetadataController(ActivityGroupMetadataService activityGroupMetadataService) {
		this.activityGroupMetadataService = activityGroupMetadataService;
	}
	
	@GetMapping()
	public List<ActivityGroupMetadataDTO> get() {
		return StreamSupport.stream(activityGroupMetadataService.get().spliterator(), false)
				.map(ActivityGroupMetadataDTO::create)
				.toList();
	}
}
