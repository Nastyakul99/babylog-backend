package kulav.babylog.services;

import java.util.List;
import org.springframework.stereotype.Service;
import kulav.babylog.models.Activity;
import kulav.babylog.repositories.ActivityRepository;

@Service
public class ActivityService {
	
	private final ActivityRepository activityRepository;
	
	public ActivityService(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}
	
	public List<Activity> get() {
		return activityRepository.findAll();
	}
	
	public List<Activity> getByGroupId(long id) {
		return activityRepository.findByGroup(id);
	}
	
	public Activity getById(long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
	}

}
