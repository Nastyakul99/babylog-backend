package kulav.babylog.services;

import java.util.List;
import org.springframework.stereotype.Service;
import kulav.babylog.models.metadata.ActivityMetadata;
import kulav.babylog.repositories.ActivityMetadataRepository;

@Service
public class ActivityMetadataService {

	private final ActivityMetadataRepository activityMetadataRepository;
	
	public ActivityMetadataService (ActivityMetadataRepository activityMetadataRepository) {
		this.activityMetadataRepository = activityMetadataRepository;
	}
	
	public List<ActivityMetadata> get() {
		return activityMetadataRepository.findAll();
	}
}
