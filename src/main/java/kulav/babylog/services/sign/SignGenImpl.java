package kulav.babylog.services.sign;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;

import kulav.babylog.models.sign.request.SignedRequest;
import kulav.babylog.utils.ParamQueryGenerator;

@Component
public class SignGenImpl implements SignGen {
	
	private Environment env;
	
	@Value("${kulav.appid}")
	private String appId;
	
	public SignGenImpl(Environment env) {
		this.env = env;
	}
	
	public String generate(SignedRequest request) {
		Data data = request.createData(appId);
		return generate(data);
	}
	

	
	// Формируем строку для вычисления подписи
	private String genParamsQuery(Data data) {
		Map<String, String> map  = createMap(data);
		return ParamQueryGenerator.generateURL(map);
	}
	
	private Map<String, String> createMap(Data data) {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("app_id", data.getAppId());
		map.put("user_id", String.valueOf(data.getUserId()));
		map.put("request_id", data.getRequestId());
		map.put("ts", data.getTs());
		return map;
	}

	@Override
	public String generate(Data data) {
		String paramsQuery = genParamsQuery(data);
		// Значение защищённого ключа из настроек приложения
		String secretKey = env.getProperty("SECRET_KEY");
		byte[] hash = Hashing.hmacSha256(secretKey.getBytes(StandardCharsets.UTF_8))
				.hashString(paramsQuery, StandardCharsets.UTF_8).asBytes();
		String encodeHash = BaseEncoding.base64().encode(hash);
		String res = encodeHash.replaceAll("\\+", "-").replaceAll("/", "_").replaceAll("=", "");
		return res;
	}

}
