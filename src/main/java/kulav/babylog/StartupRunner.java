package kulav.babylog;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import kulav.babylog.models.Activity;
import kulav.babylog.models.ActivityGroup;
import kulav.babylog.models.TypeActivityRecord;
import kulav.babylog.repositories.ActivityGroupRepository;
import kulav.babylog.repositories.ActivityRepository;

@Component
public class StartupRunner implements CommandLineRunner {
	
	@Autowired
	private ActivityGroupRepository activityGroupRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Transactional
    @Override
    public void run(String... args) throws Exception {
    	List<ActivityGroup> groups = List.of(new ActivityGroup("Кормление", "Кормление", "https://img.icons8.com/plasticine/100/baby-bottle.png"),
    			new ActivityGroup("Сон", "Сон", "https://img.icons8.com/plasticine/100/crib.png"),
    			new ActivityGroup("Подгузники", "Подгузники", "https://img.icons8.com/plasticine/100/nappy.png"),
    			new ActivityGroup("Навыки", "Навыки", "https://img.icons8.com/plasticine/100/learning.png"));
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
    			new Activity("Первые шаги", "Первые шаги", groups.get(3).getImg(), groups.get(3), TypeActivityRecord.TEXT_NOTE));
    	
    	activities.stream()
    	.forEach(a -> activityRepository.save(a));
    }
}