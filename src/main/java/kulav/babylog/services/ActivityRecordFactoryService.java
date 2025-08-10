package kulav.babylog.services;

import org.springframework.stereotype.Component;
import kulav.babylog.models.Activity;
import kulav.babylog.models.dto.records.ActivityRecordDTO;
import kulav.babylog.models.records.ActivityRecord;
import kulav.babylog.models.records.TextNoteRecord;
import kulav.babylog.models.records.TimeRangeRecord;
import kulav.babylog.models.dto.records.TimeRangeRecordDTO;
import kulav.babylog.models.dto.records.TextNoteRecordDTO;

@Component
public class ActivityRecordFactoryService {

    public ActivityRecord createRecord(Activity activity, ActivityRecordDTO request) {
        switch (activity.getType()) {
            case BASE_RECORD -> {
            	ActivityRecord record = new ActivityRecord();
                return setupBase(record, activity, request);
            }
            case TIME_RANGE -> {
                TimeRangeRecord record = new TimeRangeRecord();
                check(request, TimeRangeRecordDTO.class);
                record.setEndTime(((TimeRangeRecordDTO)request).getEndTime());
                return setupBase(record, activity, request);
            }
            case TEXT_NOTE -> {
                TextNoteRecord record = new TextNoteRecord();
                check(request, TextNoteRecordDTO.class);
                record.setComment(((TextNoteRecordDTO)request).getComment());
                return setupBase(record, activity, request);
            }
            default -> throw new IllegalArgumentException("Unsupported activity type");
        }
    }
    
    //TODO: дописать
    private <T extends ActivityRecordDTO> void check(ActivityRecordDTO request, Class<T> clazz) {
        if (!clazz.isInstance(request)) {
            throw new IllegalArgumentException("Expected DTO of type " + clazz.getSimpleName() +
                    ", but got " + request.getClass().getSimpleName());
        }
    }

    private ActivityRecord setupBase(ActivityRecord record,
    		Activity activity, ActivityRecordDTO request) {
    	record.setStartTime(request.getStartTime());
        record.setActivity(activity);
        return record;
    }
}

