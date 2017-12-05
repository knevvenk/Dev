
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class IdentityCheckServiceRequest {
	String transactionId;
	String clientInstanceId;
	JSONObject payload = new JSONObject();
	String apiName;	

	public IdentityCheckServiceRequest(String apiName_, String transactionId_, String clientInstanceId_, JSONObject payloadJSON) {
		transactionId = transactionId_;
		clientInstanceId = clientInstanceId_;
		this.payload = payloadJSON;
		apiName = apiName_;
	}

	public JSONObject getPayload() {
		return payload;
	}

	public void setPayload(JSONObject payload) {
		this.payload = payload;
	}

	public String getClientInstanceId() {
		return clientInstanceId;
	}

	public void setClientInstanceId(String client_instance_id) {
		this.clientInstanceId = client_instance_id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transaction_id) {
		this.transactionId = transaction_id;
	}
	
	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName_) {
		this.apiName = apiName_;
	}

}
