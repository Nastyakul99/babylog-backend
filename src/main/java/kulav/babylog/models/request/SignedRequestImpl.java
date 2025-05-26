package kulav.babylog.models.request;

import kulav.babylog.services.sign.DataImpl;
import lombok.Data;

@Data
public class SignedRequestImpl implements SignedRequest {
	
	private String sign;
	
	@PartOfPayload
	private String param1;
	
	@PartOfPayload
	private String param2;

	private String ts;
	
	private String userId;
	
	public Payload getPayload() {
		return new Payload(){
			@Override
			public String genParamQuery() {
				return genParamQuery(SignedRequestImpl.this);
			}};
	}

	@Override
	public kulav.babylog.services.sign.Data createData(String appId) {
		kulav.babylog.services.sign.Data data = new DataImpl();
		
		data.setAppId(appId);
		
		data.setRequestId(this.getPayload().genParamQuery()); 

		data.setTs(this.getTs());
		
		data.setUserId(this.getUserId());
		
		return data;
	}
}
