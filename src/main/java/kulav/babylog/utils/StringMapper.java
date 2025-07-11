package kulav.babylog.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class StringMapper {

	public static String map(Object o) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			return mapper.writeValueAsString(o);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
