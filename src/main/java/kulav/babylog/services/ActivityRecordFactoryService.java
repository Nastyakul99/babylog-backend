package kulav.babylog.services;

import org.springframework.stereotype.Component;
import kulav.babylog.models.Activity;
import kulav.babylog.models.dto.CreateActivityRecordRequest;
import kulav.babylog.models.records.ActivityRecord;
import kulav.babylog.models.records.TextNoteRecord;
import kulav.babylog.models.records.TimeRangeRecord;

@Component
public class ActivityRecordFactoryService {

    public ActivityRecord createRecord(Activity activity, CreateActivityRecordRequest request) {
        switch (activity.getType()) {
            case BASE_RECORD -> {
            	ActivityRecord record = new ActivityRecord();
                return setupBase(record, activity, request);
            }
            case TIME_RANGE -> {
                TimeRangeRecord record = new TimeRangeRecord();
                record.setEndTime(request.endTime());
                return setupBase(record, activity, request);
            }
            case TEXT_NOTE -> {
                TextNoteRecord record = new TextNoteRecord();
                record.setComment(request.comment());
                return setupBase(record, activity, request);
            }
            default -> throw new IllegalArgumentException("Unsupported activity type");
        }
    }

    private ActivityRecord setupBase(ActivityRecord record,
    		Activity activity, CreateActivityRecordRequest request) {
    	record.setStartTime(request.startTime());
        record.setActivity(activity);
        return record;
    }
}

