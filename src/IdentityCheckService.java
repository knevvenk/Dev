
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author banve02
 *
 */

@RestController
@RequestMapping({ "/IdentityCheckService" })
public class IdentityCheckService {

	private static String server = "";
	private static RestTemplate rest;
	private static HttpHeaders headers;
	private static String host;
	private static final String ID_CHECK_TRUSTCERTID = "ID_CHECK_TRUSTCERTID";
	private static FilterLogger logger = new FilterLogger(FilterLogger.MCID_TRANSACTION_APPENDER);
	
	/**
	 * Method to initialize serverURL, host, and Rest template with keystore and truststore for SSL.
	 */
	private static void initIdentityCheckService(){
		try {
			if(null == host || host.trim().length() == 0){
				host = InetAddress.getLocalHost().getHostName();
			}
		} catch (UnknownHostException e) {
			host = "Unknown";
			logger.logException("Error in IdentityCheckService init: ", e);
		}
	}
	
	/**
	 * POST method to get the response from the server
	 * 
	 * @param JSONObject
	 *            from the handler
	 * @return JSONObject response
	 * @throws IdCheckException
	 */
	@RequestMapping(value = { "/getAuthResponse" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<IdentityCheckServiceResponse> getAuthResponse(@RequestBody JSONObject request){
		initIdentityCheckService();		
		JSONObject payload = parseRequest(request);
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "OAUTH_-----");

		String transactionId = payload.get("transactionId").toString();
		logger.logInfo("Get the server response for the transaction-id " + transactionId);

		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		ResponseEntity<JSONObject> responseEntity = null;
		try {
			responseEntity = rest.exchange(server+"=" + transactionId, HttpMethod.GET, requestEntity,
					JSONObject.class);
		} catch (ResourceAccessException resourceAccessEx) {
			logger.logInfo("Connection refused:: I/O error on GET request");
			IdentityCheckServiceResponse response = generateErrorReponse("301", resourceAccessEx.getMessage());
			return new ResponseEntity<IdentityCheckServiceResponse>(response, HttpStatus.OK);
		} catch (HttpStatusCodeException httpStatusCodeEx) {
			logger.logInfo("Status Code Returned from the server is [ " + httpStatusCodeEx.getStatusCode() + " ]");
			String httpStatusCode = httpStatusCodeEx.getStatusCode().toString();
			IdentityCheckServiceResponse response = generateErrorReponse(httpStatusCode, httpStatusCodeEx.getMessage());
			return new ResponseEntity<IdentityCheckServiceResponse>(response, HttpStatus.OK);
		}

		if (responseEntity == null) {
			logger.logInfo("Received Empty Reponse from the Server");			
		}
		IdentityCheckServiceResponse response = generateResponse(responseEntity);
		return new ResponseEntity<IdentityCheckServiceResponse>(response, HttpStatus.OK);
	}

	/**
	 * POST method to post the request to server
	 * 
	 * @param JSONObject
	 *            from the handler
	 * @return JSONObject response
	 * @throws IdCheckException
	 */
	@RequestMapping(value = { "/postAuthRequest" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IdentityCheckServiceResponse> postAuthRequest(@RequestBody JSONObject request){
		
		initIdentityCheckService();
		JSONObject payload = parseRequest(request);
		
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "OAUTH ---");

		String transactionId = payload.get("transactionId").toString();
		logger.logInfo("Post the transaction-id " + transactionId + " to the server");

		HttpEntity<String> requestEntity = new HttpEntity<String>(JSONValue.toJSONString(payload), headers);
		ResponseEntity<JSONObject> responseEntity = null;
		try {
			responseEntity = rest.exchange(server, HttpMethod.POST, requestEntity, JSONObject.class);
		} catch (ResourceAccessException resourceAccessEx) {
			logger.logInfo("Connection refused:: I/O error on POST request");
			IdentityCheckServiceResponse response = generateErrorReponse("301", resourceAccessEx.getMessage());
			return new ResponseEntity<IdentityCheckServiceResponse>(response, HttpStatus.OK);
		} catch (HttpStatusCodeException httpStatusCodeEx) {
			logger.logInfo("Status Code Returned from the server is [ " + httpStatusCodeEx.getStatusCode() + " ]");			
			String httpStatusCode = httpStatusCodeEx.getStatusCode().toString();			
			IdentityCheckServiceResponse response = generateErrorReponse(httpStatusCode, httpStatusCodeEx.getMessage());
			return new ResponseEntity<IdentityCheckServiceResponse>(response, HttpStatus.OK);
		}

		if (responseEntity == null) {
			logger.logInfo("Received Empty Reponse from the Server");			
		}
		IdentityCheckServiceResponse response = generateResponse(responseEntity);
		return new ResponseEntity<IdentityCheckServiceResponse>(response, HttpStatus.OK);
	}

	/**
	 * Parse the input JSONObject and returns the actual payload JSONObject
	 * 
	 * @param JSONObject
	 *            from API methods
	 * @return payload JSONObject
	 * @throws IdCheckException
	 */
	private JSONObject parseRequest(JSONObject request){

		String payload = JSONValue.toJSONString(request.get("payload"));
		JSONParser parser = new JSONParser();
		JSONObject payloadJson = null;
		try {
			payloadJson = (JSONObject) parser.parse(payload);
		} catch (ParseException parseException) {
			
		}
		if (payloadJson == null) {
			logger.logInfo("Invalid or null request received from the client");
			
		}
		return payloadJson;
	}

	/**
	 * Generate the response from the ResponseEntity object
	 * 
	 * @param ResponseEntity
	 *            from the server
	 * @return IdentityCheckServiceResponse JSONObject
	 */
	private IdentityCheckServiceResponse generateResponse(ResponseEntity<JSONObject> responseEntity) {

		IdentityCheckServiceResponse response = new IdentityCheckServiceResponse();
		response.setServerInstanceId(host + ":" + Thread.currentThread().getName());
		Map<Object, Object> innerResponse = new HashMap<Object, Object>();
		innerResponse.put("httpStatusCode", responseEntity.getStatusCode().toString());		
		innerResponse.put("headers", "");
		response.setResponse(innerResponse);
		response.setBody(responseEntity.getBody());

		return response;
	}

	/**
	 * Generate Error response for connection/read timeout
	 * 
	 * @param httpStatusCode
	 * @param errorMessage
	 * @return
	 */
	private IdentityCheckServiceResponse generateErrorReponse(String httpStatusCode, String errorMessage) {
		
		IdentityCheckServiceResponse response = new IdentityCheckServiceResponse();
		response.setServerInstanceId(host + ":" + Thread.currentThread().getName());
		Map<Object, Object> innerResponse = new HashMap<Object, Object>();
		innerResponse.put("httpStatusCode", httpStatusCode);
		innerResponse.put("headers", "");
		response.setResponse(innerResponse);
		logger.logInfo("Error Message recieved from the Server, the message is :: "+errorMessage);
		JSONObject error = new JSONObject();
		error.put("error", errorMessage);
		if(httpStatusCode == "301")
			error.put("responseCode", "301 - Connection/Read Timeout");
		else
			error.put("responseCode", httpStatusCode);
		response.setBody(error);

		return response;
	}
	
	
	/**
	 * calling this from js Ajax post
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/getTxnResponse" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_XML_VALUE)

	public ResponseEntity<String> getTxnResponse(@RequestBody String request){			 

		String txnProxyPAN = request.toString();
		String status = "";//M3DSUtil.getTxnStatusFromCache(txnProxyPAN);
		org.json.JSONObject response = new org.json.JSONObject();
		response.put("txnStatus", status);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        
		ResponseEntity<String> resEntity = new ResponseEntity<String>(response.toString(), headers, HttpStatus.OK);
			
		return resEntity;
	}
}