package kulav.babylog;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import kulav.babylog.models.Activity;
import kulav.babylog.models.ActivityGroup;
import kulav.babylog.models.TypeActivityRecord;
import kulav.babylog.models.metadata.ActivityGroupMetadata;
import kulav.babylog.models.metadata.ActivityMetadata;
import kulav.babylog.models.metadata.StatisticType;
import kulav.babylog.repositories.ActivityGroupMetadataRepository;
import kulav.babylog.repositories.ActivityGroupRepository;
import kulav.babylog.repositories.ActivityMetadataRepository;
import kulav.babylog.repositories.ActivityRepository;

@Component
public class StartupRunner implements CommandLineRunner {
	
	@Autowired
	private ActivityGroupRepository activityGroupRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private ActivityGroupMetadataRepository activityGroupMetadataRepository;
	
	@Autowired
	private ActivityMetadataRepository activityMetadataRepository;
	
	@Transactional
    @Override
    public void run(String... args) throws Exception {
    	List<ActivityGroup> groups = List.of(new ActivityGroup("Кормление", "Кормление", "https://img.icons8.com/plasticine/100/baby-bottle.png"),
    			new ActivityGroup("Сон", "Сон", "https://img.icons8.com/plasticine/100/crib.png"),
    			new ActivityGroup("Подгузники", "Подгузники", "https://img.icons8.com/plasticine/100/nappy.png"),
    			new ActivityGroup("Навыки", "Навыки", "https://img.icons8.com/plasticine/100/learning.png"),
    			new ActivityGroup("Здоровье", "Здоровье", "https://img.icons8.com/plasticine/100/hospital-3.png"));
    	groups.stream()
    	.forEach(g -> activityGroupRepository.save(g));
    	
    	List<Activity> activities = List.of(new Activity("Левая", "Левая", "https://img.icons8.com/plasticine/100/l.png", groups.get(0), TypeActivityRecord.TIME_RANGE),
    			new Activity("Правая", "Правая", "https://img.icons8.com/plasticine/100/r.png", groups.get(0), TypeActivityRecord.TIME_RANGE),
    			new Activity("Бутылочка смесь", "Бутылочка смесь", groups.get(0).getImg(), groups.get(0), TypeActivityRecord.ML_RECORD),
    			new Activity("Бутылочка молоко", "Бутылочка молоко", "https://img.icons8.com/plasticine/100/manual-breast-pump.png", groups.get(0), TypeActivityRecord.ML_RECORD),
    			new Activity("Еда", "Еда", "https://img.icons8.com/plasticine/100/brocolini1.png", groups.get(0), TypeActivityRecord.TEXT_NOTE),
    			
    			new Activity("Мокрый", "Мокрый", "https://img.icons8.com/plasticine/100/water.png", groups.get(2), TypeActivityRecord.BASE_RECORD),
    			new Activity("Грязный", "Грязный", "https://img.icons8.com/plasticine/100/heap-of-spice.png", groups.get(2), TypeActivityRecord.BASE_RECORD),
    			
    			new Activity("Сон дневной", "Сон дневной", groups.get(1).getImg(), groups.get(1), TypeActivityRecord.TIME_RANGE),
    			new Activity("Сон ночной", "Сон ночной", "https://img.icons8.com/plasticine/100/bright-moon.png", groups.get(1), TypeActivityRecord.COUNT_RECORD),
    			
    			new Activity("Стал держать голову", "Стал держать голову", groups.get(3).getImg(), groups.get(3), TypeActivityRecord.TEXT_NOTE),
    			new Activity("Перевернулся", "Перевернулся", groups.get(3).getImg(), groups.get(3), TypeActivityRecord.TEXT_NOTE),
    			new Activity("Сел", "Сел", groups.get(3).getImg(), groups.get(3), TypeActivityRecord.TEXT_NOTE),
    			new Activity("Пополз", "Пополз", groups.get(3).getImg(), groups.get(3), TypeActivityRecord.TEXT_NOTE),
    			new Activity("Первые шаги", "Первые шаги", groups.get(3).getImg(), groups.get(3), TypeActivityRecord.TEXT_NOTE),
    			
    			new Activity("Лекарство", "Лекарство", "https://img.icons8.com/plasticine/100/pill.png", groups.get(4), TypeActivityRecord.TEXT_NOTE),
    			new Activity("Температура", "Температура", "https://img.icons8.com/plasticine/100/medical-thermometer.png", groups.get(4), TypeActivityRecord.TEXT_NOTE),
    			new Activity("Прививка", "Прививка", groups.get(4).getImg(), groups.get(4), TypeActivityRecord.TEXT_NOTE));
    	
    	activities.stream()
    	.forEach(a -> activityRepository.save(a));
    	
    	List<ActivityGroupMetadata> groupsMetadata =  List.of(new ActivityGroupMetadata(groups.get(0)),
    			new ActivityGroupMetadata(groups.get(1)));
    	
    	groupsMetadata.stream()
    	.forEach(g -> activityGroupMetadataRepository.save(g));
    	
    	////
    	List<ActivityMetadata> activityMetadata = List.of(
    			new ActivityMetadata(activities.get(0), "#0B4E65", "Режим кормлений", StatisticType.TIME_RANGE_BAR_CHART),
    			new ActivityMetadata(activities.get(1), "#3F7F9E", "Режим кормлений", StatisticType.TIME_RANGE_BAR_CHART),
    			new ActivityMetadata(activities.get(0), "#E2C9CA", "Длина кормлений", StatisticType.SUM_TIME_BAR_CHART),
    			new ActivityMetadata(activities.get(1), "#0B4E65", "Длина кормлений", StatisticType.SUM_TIME_BAR_CHART),
    			new ActivityMetadata(activities.get(2), "#3F7F9E", "Длина кормлений", StatisticType.SUM_TIME_BAR_CHART),
    			new ActivityMetadata(activities.get(2), "#E2C9CA", "Объем кормлений", StatisticType.SUM_VAL_BAR_CHART),
    			
    			new ActivityMetadata(activities.get(7), "#3F7F9E", "Режим снов", StatisticType.TIME_RANGE_BAR_CHART),
    			new ActivityMetadata(activities.get(8), "#B47C50", "Режим снов", StatisticType.TIME_RANGE_BAR_CHART),
    			new ActivityMetadata(activities.get(7), "#3F7F9E", "Длина сна", StatisticType.SUM_TIME_BAR_CHART),
    			new ActivityMetadata(activities.get(8), "#B47C50", "Длина сна", StatisticType.SUM_TIME_BAR_CHART),
    			////
    			new ActivityMetadata(activities.get(0), null, "ГВ раз в день", StatisticType.NUMBER_OF_TIMES_PER_DAY),
    			new ActivityMetadata(activities.get(1), null, "ГВ раз в день", StatisticType.NUMBER_OF_TIMES_PER_DAY),
    			new ActivityMetadata(activities.get(0), null, "Длина кормлений за день", StatisticType.SUM_TIME_PER_DAY),
    			new ActivityMetadata(activities.get(1), null, "Длина кормлений за день", StatisticType.SUM_TIME_PER_DAY),
    			
    			new ActivityMetadata(activities.get(2), null, "Объем смеси за день", StatisticType.SUM_VAL_PER_DAY),
    			new ActivityMetadata(activities.get(8), null, "Количество пробуждений за ночь", StatisticType.SUM_ONCE_PER_DAY));
    	
    	activityMetadata.stream()
    	.forEach(g -> activityMetadataRepository.save(g));
    }
}