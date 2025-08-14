package kulav.babylog.models.dto;

import kulav.babylog.models.dto.records.ActivityRecordDTO;
import kulav.babylog.models.sign.request.PartOfPayload;
import kulav.babylog.models.sign.request.Payload;
import kulav.babylog.models.sign.request.SignedRequest;
import kulav.babylog.services.sign.DataImpl;
import lombok.Data;

@Data
public class ActivityRecordSignedRequest implements SignedRequest {

	private String sign;

	private String ts;
	
	@PartOfPayload
	private ActivityRecordDTO activityRecord;
	
	private long userId;
	
	public Payload getPayload() {
		return new Payload(){
			@Override
			public String genParamQuery() {
				return genParamQuery(ActivityRecordSignedRequest.this);
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
