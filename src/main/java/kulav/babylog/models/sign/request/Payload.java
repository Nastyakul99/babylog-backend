package kulav.babylog.models.sign.request;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.function.ThrowingFunction;

import kulav.babylog.utils.ParamQueryGenerator;

public interface Payload {
	
	static final String SEPARATOR = ";";

	public String genParamQuery();
	
	public default String genParamQuery(Object o) {
		
		ThrowingFunction<Field, String> tf = f -> String.valueOf(f.get(o));
		
		Map<String, String> map = new HashMap<String, String>();
		Field[] fields = o.getClass().getDeclaredFields();
		Arrays.stream(fields)
		.filter(f -> f.isAnnotationPresent(PartOfPayload.class))
		.peek(f -> f.setAccessible(true))
		.peek(f -> map.put(f.getName(), tf.apply(f)))
		.forEach(f -> f.setAccessible(false));
		
		return ParamQueryGenerator.generate(map, SEPARATOR);
	}
}
