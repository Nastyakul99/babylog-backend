package kulav.babylog.services.sign;

@lombok.Data
public class DataImpl implements Data{

	private String appId;
	
	private String requestId;

	private String ts;
	
	private String userId;
}
