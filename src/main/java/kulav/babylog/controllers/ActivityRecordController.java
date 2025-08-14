package kulav.babylog.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kulav.babylog.models.dto.ActivityRecordSignedRequest;
import kulav.babylog.models.dto.records.ActivityRecordDTO;
import kulav.babylog.models.records.ActivityRecord;
import kulav.babylog.services.ActivityRecordService;

@RestController
@RequestMapping("/activityRecords")
public class ActivityRecordController {

    private final ActivityRecordService activityRecordService;

    public ActivityRecordController(ActivityRecordService activityRecordService) {
        this.activityRecordService = activityRecordService;
    }

    @PostMapping
    public ActivityRecordDTO create(@RequestBody ActivityRecordSignedRequest request) {
        ActivityRecord createdRecord = activityRecordService.create(request.getActivityRecord());
        ActivityRecordDTO dto = activityRecordService.map(createdRecord);
        return dto;
    }

//    // Обновление записи (PUT /api/activity-records/{id})
//    @PutMapping("/{id}")
//    public ResponseEntity<ActivityRecordDTO> update(
//            @PathVariable Long id,
//            @RequestBody ActivityRecordDTO request) {
//
//        // Устанавливаем id из URL в DTO, чтобы избежать рассогласования
//        request.setId(id);
//
//        ActivityRecord updatedRecord = activityRecordService.update(request);
//        ActivityRecordDTO dto = activityRecordService.map(updatedRecord);
//        return ResponseEntity.ok(dto);
//    }
//
//    // Удаление записи (DELETE /api/activity-records/{id})
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        activityRecordService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // Получение записи по id (GET /api/activity-records/{id})
//    @GetMapping("/{id}")
//    public ActivityRecordDTO getById(@PathVariable Long id) {
//        return activityRecordService.activityRecordRepository.findById(id)
//                .map(activityRecordService::map)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // (опционально) Получение списка всех записей
//    @GetMapping
//    public ResponseEntity<List<ActivityRecordDTO>> getAll() {
//        List<ActivityRecordDTO> list = activityRecordService.activityRecordRepository.findAll()
//                .stream()
//                .map(activityRecordService::map)
//                .toList();
//        return ResponseEntity.ok(list);
//    }
}