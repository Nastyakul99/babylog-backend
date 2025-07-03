package kulav.babylog.controllers;

import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kulav.babylog.models.dto.ActivityGroupDTO;
import kulav.babylog.services.ActivityGroupService;

@RestController
@RequestMapping({"/activityGroups"})
public class ActivityGroupController {

	private final ActivityGroupService activityGroupService;
	
	public ActivityGroupController(ActivityGroupService activityGroupService) {
		this.activityGroupService = activityGroupService;
	}
	
	@GetMapping()
	public List<ActivityGroupDTO> get() {
		return StreamSupport.stream(activityGroupService.get().spliterator(), false)
				.map(ActivityGroupDTO::create)
				.toList();
	}
}
