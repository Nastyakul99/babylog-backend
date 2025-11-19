package kulav.babylog.controllers;

import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kulav.babylog.models.dto.metadata.ActivityMetadataDTO;
import kulav.babylog.services.ActivityMetadataService;

@RestController
@RequestMapping({"/activityMetadata"})
public class ActivityMetadataController {

	private final ActivityMetadataService activityMetadataService;
	
	public ActivityMetadataController(ActivityMetadataService activityMetadataService) {
		this.activityMetadataService = activityMetadataService;
	}
	
	@GetMapping()
	public List<ActivityMetadataDTO> get() {
		return StreamSupport.stream(activityMetadataService.get().spliterator(), false)
				.map(ActivityMetadataDTO::create)
				.toList();
	}
}
