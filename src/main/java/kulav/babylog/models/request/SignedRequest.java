package kulav.babylog.models.request;

import kulav.babylog.services.sign.Data;

public interface SignedRequest {

	public String getSign();
	
	public String getTs();
	
	public String getUserId();
	
	public Payload getPayload();
	
	public Data createData(String appId);

}
