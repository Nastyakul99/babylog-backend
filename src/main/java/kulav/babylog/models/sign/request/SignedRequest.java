package kulav.babylog.models.sign.request;

import kulav.babylog.models.dto.DTO;
import kulav.babylog.services.sign.Data;

public interface SignedRequest extends DTO {

	public String getSign();
	
	public String getTs();
	
	//vkId
	public long getUserId();
	
	public Payload getPayload();
	
	public Data createData(String appId);

}
