package kulav.babylog.services.sign;

//данные для формирования подписи
public interface Data {

	public String getAppId();
	
	public String getRequestId();

	public String getTs();
	
	public String getUserId();
	
	public void setAppId(String appId);
	
	public void setRequestId(String requestId);

	public void setTs(String ts);
	
	public void setUserId(String userId);
}