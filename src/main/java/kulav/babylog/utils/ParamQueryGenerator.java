package kulav.babylog.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ParamQueryGenerator {
	
	private static final String SEPARATOR = "&";

	/**
	 * @param map - параметры и их значения
	 * @return строка в формате  application/x-www-form-urlencoded 
	 */
	public static String generateURL(Map<String, String> map) {
			return generate(map, SEPARATOR);
	}
	
	public static String generate(Map<String, String> map, String sep) {
		return map.entrySet().
				stream().
				map(set -> generatePartURL(set))
				.collect(Collectors.joining(sep));
	}
	
	private static String generatePartURL(Entry<String, String> entry) {
		return (urlEncode(entry.getKey()) + "=" + urlEncode(entry.getValue()));
	}
	
	private static String urlEncode(String str) {
		return URLEncoder.encode(str, StandardCharsets.UTF_8);
	}
}
