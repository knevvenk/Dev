
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;

public class IdentityCheckServiceResponse {

	String serverInstanceId;
	Map<Object, Object> response = new HashMap<Object, Object>();
	JSONObject body = new JSONObject();

	public String getServerInstanceId() {
		return serverInstanceId;
	}

	public void setServerInstanceId(String serverInstanceId_) {
		this.serverInstanceId = serverInstanceId_;
	}

	public Map<Object, Object> getResponse() {
		return response;
	}

	public JSONObject getBody() {
		return body;
	}

	public void setBody(JSONObject body) {
		this.body = body;
	}

	public void setResponse(Map<Object, Object> response) {
		this.response = response;
	}

}
