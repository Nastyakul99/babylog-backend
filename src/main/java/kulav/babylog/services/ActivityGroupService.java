package kulav.babylog.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import kulav.babylog.models.ActivityGroup;
import kulav.babylog.repositories.ActivityGroupRepository;

@Service
public class ActivityGroupService {

	private final ActivityGroupRepository activityGroupRepository;
	
	public ActivityGroupService (ActivityGroupRepository activityGroupRepository) {
		this.activityGroupRepository = activityGroupRepository;
	}
	
	public Iterable<ActivityGroup> get() {
		return activityGroupRepository.findAll();
	}
	
	public Optional<ActivityGroup> getById(long id) {
		return activityGroupRepository.findById(id);
	}
}
