package kulav.babylog.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kulav.babylog.models.dto.ActivityDTO;
import kulav.babylog.services.ActivityService;

@RestController
@RequestMapping({"/activities"})
public class ActivityController {

	private final ActivityService activityService;
	
	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	@GetMapping("/group/{id}")
	public List<ActivityDTO> getByGroupId(@PathVariable long id) {
		return activityService.getByGroupId(id)
				.stream()
				.map(ActivityDTO::create)
				.toList();
	}
}
