package kulav.babylog.models.sign.request;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import kulav.babylog.models.dto.DTO;
import kulav.babylog.utils.ParamQueryGenerator;
import kulav.babylog.utils.ReflectionUtils;

public interface Payload {
	
	static final String SEPARATOR = ";";

	public String genParamQuery();
	
	public default String genParamQuery(Object o) {
		List<Field> filterFields = filterPartOfPayloadDtos(o);
		
		//TODO: дописать
		if (filterFields.size() > 1) {
			throw new RuntimeException();
		}
		
		if (filterFields.size() == 1) {
			Field f = filterFields.get(0);
				Object newO = getField(f, o);
				Function<Object, List<Field>> func = obj -> Arrays.asList(ReflectionUtils.getAllFields(obj.getClass()));
				return genParamQuery(newO, func);
		}
		
		return genParamQuery(o, this::filterPartOfPayload);
	}
	
	default String genParamQuery(Object o, Function<Object, List<Field>> filter) {
		Map<String, String> map = new TreeMap<String, String>();
		List<Field> filterFields = filter.apply(o);
		filterFields.stream()
		.forEach(f -> map.put(f.getName(), String.valueOf(getField(f, o))));
		
		return ParamQueryGenerator.generate(map, SEPARATOR);
	}
	
	default List<Field> filterPartOfPayloadDtos(Object o) {
		Field[] fields = ReflectionUtils.getAllFields(o.getClass());
		return Arrays.stream(fields)
		.filter(f ->  f.isAnnotationPresent(PartOfPayload.class) && getField(f, o) instanceof DTO)
		.toList();
	}
	
	default List<Field> filterPartOfPayload(Object o) {
		Field[] fields = ReflectionUtils.getAllFields(o.getClass());
		return Arrays.stream(fields)
		.filter(f ->  f.isAnnotationPresent(PartOfPayload.class))
		.toList();
	}
	
	default Object getField(Field f, Object o) {
		try {
			Object res = null;
			f.setAccessible(true);
			res = f.get(o);
			f.setAccessible(false);
			return res;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
