package kulav.babylog.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kulav.babylog.models.Activity;
import kulav.babylog.models.dto.CreateActivityRecordRequest;
import kulav.babylog.models.records.ActivityRecord;
import kulav.babylog.repositories.ActivityRecordRepository;
import kulav.babylog.repositories.ActivityRepository;

@Service
public class ActivityRecordService {

	private final ActivityRepository activityRepository;
    private final ActivityRecordFactoryService factory;
    private final ActivityRecordRepository activityRecordRepository;

    public ActivityRecordService(
            ActivityRepository activityRepository,
            ActivityRecordFactoryService factory,
            ActivityRecordRepository activityRecordRepository) {
        this.activityRepository = activityRepository;
        this.factory = factory;
        this.activityRecordRepository = activityRecordRepository;
    }

    @Transactional
    public ActivityRecord create(CreateActivityRecordRequest request) {
        Activity activity = activityRepository.findById(request.activityId())
                .orElseThrow(() -> new IllegalArgumentException("Activity not found"));

        ActivityRecord record = factory.createRecord(activity, request);
        return activityRecordRepository.save(record);
    }
}
