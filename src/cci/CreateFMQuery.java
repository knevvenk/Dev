package cci;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class CreateFMQuery {
	
	public static void main(String[] args) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("C:\\query\\FMInsertQuery_13032019_1.sql");
			for(int i=0;i<10000;i++) {
				Integer txnId = 590004;
				txnId += (i*4);
				String txn = ""+txnId;
//				System.out.println(getRA3dsInsertQuery(txn));
				fileWriter.write(getFmInsertQuery());
				fileWriter.write("\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (fileWriter != null) {
					fileWriter.flush();
					fileWriter.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getIDSFactMgtInsertQuery() {
		String txnId = UUID.randomUUID().toString();
		String query = null;
		query = "INSERT INTO DC_ACCT_AUDIT_LOG (ACCT_AUDIT_LOG_PK, CLIENT_TXN_ID, ACCT_ID, TENANT_ID, TENANT_FK, EVENT_TYPE, DELTA_STATE, EVENT_SOURCE, STATUS) VALUES (";
		query += "'"+txnId+"', '"+UUID.randomUUID().toString()+"', '2ZCXNcRZAxO8DFV4dAxSlBFjEbUowjSa2rbp/V2X9oDmf0fhyBsQ2w==', 'SAFEBANK_NETBANKING', 'eff42cd8-6741-4fa6-a8a8-c50309b7e17b', 'SET_FACTORS', '{\"factors_added\":{\"device_tokens\":[{\"value\":\"AI***********************************Cw\",\"device_nickname\":\"ga**********34\",\"is_default\":true,\"status\":1}]}}', 'FM', 'SUCCESS');";
		return query;		
				//('aaa', 'sdsd', '2ZCXNcRZAxO8DFV4dAxSlBFjEbUowjSa2rbp/V2X9oDmf0fhyBsQ2w==', 'SAFEBANK_NETBANKING', 'eff42cd8-6741-4fa6-a8a8-c50309b7e17b', 'SET_FACTORS', '{"factors_added":{"device_tokens":[{"value":"AI***********************************Cw","device_nickname":"ga**********34","is_default":true,"status":1}]}}', 'FM', 'SUCCESS')
	}
	private static String getFmInsertQuery() {
		String fmTxnId = UUID.randomUUID().toString();
		String CURRENT_TIMESTAMP = "CURRENT_TIMESTAMP";
		String query = null;
		query = "insert into FM_AUDITLOG (FMTXNID, OPERATION, CLIENTTXNID, CLIENTSESSIONID, TENANTID, USERNAME, MASKED_USERNAME, METHODTYPE, CHANNEL, ACTION, REQUEST, RESPONSE, OPSTATUS, TXNSTATUS, TXNSTARTTIME, TXNENDTIME, PAYSECSVCTXNID, INSTANCEID, UPDATETIME) values(";
		query += "'"+fmTxnId+"', 1, '"+UUID.randomUUID().toString()+"', 'session', 'SAFEBANK_NETBANKING', 'aUhOFWYp/s9EamfXaJtVDFbIgE0GDI1d8OMh17+OTn/D0GRZFJgsSQ==', 'a***1', 'PUSH', 'BANKING', 'login', '{\"action\":\"login\",\"channel\":\"BANKING\"}', '{\"nextActions\":[{\"action\":\"NOTIFY\",\"data\":{\"riskAdvice\":\"INCREASEAUTH\",\"riskScore\":65,\"deviceId\":\"6ix6WloHmi1E66bzAoznbYl5Gp1ptcpXqoxlIXrRW0OvIniONyR6rUwN1OmZzgdj\"}}]}', 0, "
				+ "0, "+CURRENT_TIMESTAMP+", "+CURRENT_TIMESTAMP+", "+"'"+UUID.randomUUID().toString()+"', "+"'"+UUID.randomUUID().toString()+"', "+CURRENT_TIMESTAMP+");\n";
//		
		
		query = "insert into FM_AUDITLOG (FMTXNID, OPERATION, CLIENTTXNID, CLIENTSESSIONID, TENANTID, USERNAME, MASKED_USERNAME, METHODTYPE, REQUEST, RESPONSE, OPSTATUS, TXNSTATUS, TXNSTARTTIME, TXNENDTIME, PAYSECSVCTXNID, INSTANCEID, UPDATETIME) values(";
		query += "'"+fmTxnId+"', 2, '"+UUID.randomUUID().toString()+"', 'session', 'SAFEBANK_NETBANKING', 'aUhOFWYp/s9EamfXaJtVDFbIgE0GDI1d8OMh17+OTn/D0GRZFJgsSQ==', 'a***1', 'PUSH', '{\"authType\":\"SA\"}', '{\"nextActions\":[{\"action\":\"OTP_AUTH\",\"data\":{\"methods\":{\"push\":[{\"factorDisplayName\":\"Xiaomi Mi A1\",\"factorId\":\"266885d5-168d-46e2-8382-c987ce3866ed\",\"deliveryReq\":\"false\",\"status\":\"auth_initiated\"}]}}},{\"action\":\"OTP_SELECTION\",\"data\":{\"methods\":{\"sms\":[{\"factorDisplayName\":\"*********865\",\"factorId\":\"05e048f4-894f-4ea7-9ca3-665e6a27a855\"}],\"push\":[{\"factorDisplayName\":\"Adila’s iPhone\",\"factorId\":\"266885d5-168d-46e2-8382-c987ce3866ed\"}],\"email\":[{\"factorDisplayName\":\"axxxxxxxxxxxxxxa@broadcom.com\",\"factorId\":\"4f330223-73c8-4afb-a6e4-55d95a2d8459\"}]}}}]}', 0, "
				+ "0, "+CURRENT_TIMESTAMP+", "+CURRENT_TIMESTAMP+", "+"'"+UUID.randomUUID().toString()+"', "+"'"+UUID.randomUUID().toString()+"', "+CURRENT_TIMESTAMP+");\n";
		query +="commit;\n";
		
		
		query += "insert into FM_AUDITLOG (FMTXNID, OPERATION, CLIENTTXNID, CLIENTSESSIONID, TENANTID, USERNAME, MASKED_USERNAME, METHODTYPE, REQUEST, RESPONSE, OPSTATUS, TXNSTATUS, TXNSTARTTIME, TXNENDTIME, PAYSECSVCTXNID, INSTANCEID, UPDATETIME) values(";
		query += "'"+fmTxnId+"', 3, '"+UUID.randomUUID().toString()+"', 'session', 'SAFEBANK_NETBANKING', 'aUhOFWYp/s9EamfXaJtVDFbIgE0GDI1d8OMh17+OTn/D0GRZFJgsSQ==', 'a***1', 'PUSH', '{\"authType\":\"SA\"}', '{\"authToken\":null,\"nextActions\":[{\"action\":\"INCREASEAUTH\",\"data\":null}]}', 0, "
				+ "0, "+CURRENT_TIMESTAMP+", "+CURRENT_TIMESTAMP+", "+"'"+UUID.randomUUID().toString()+"', "+"'"+UUID.randomUUID().toString()+"', "+CURRENT_TIMESTAMP+");\n";
		
		
		return query;
	}
	
	private static String getRAInsertQuery(String txnId) {
		
		String query = null;
		query = "INSERT INTO ARRFSYSAUDITLOG_BANKING (INSTANCEID, TXID, SESSIONID, CALLERID, TXNTYPE, STATUS, ORGNAME, USERNAME, HTTPDEVICEID, DEVICESIGNATURE, DEVICEIDOUT, CLIENTIPADDRESS, SDKIPADDRESS, ADD_ON_RULE_ANNOTATION, SECAUTHRESULT, RELATEDINSTANCEID, RELATEDTXID, FRAUDSTATUS, CASESTATUS, ALERT_STATUS, USERREFID, MODEL_SCORE, PREDICTIVE_SCORE, USERASIS, RF_VERSION, DEVICETYPE) VALUES ('20'";
		query += ",'"+txnId+"', '20:4000177312', 'FM', '1', '0', 'DEFAULTORG', 'GOHL3EICIX7Z+OUNCRNJAV6FAIXZYTMY7FRY+92RCKXHYJISRVW7OG==', 'oLdqFGWvuMkpgLS4+OLlveiHE5s3XeBd0R2eMkrpdXj76OWiNjswRE67lw4PwQfB', '{\"DEVICESIG\":{\"VERSION\":\"5.0\", \"EXTERNALIP\":{ \"externalip\":\"155.35.144.173\"},\"EXTRA\":{ \"NetscapePlugins\":{\"Chrome PDF Plugin\":\"\",\"Chrome PDF Viewer\":\"\",\"Native Client\":\"\",\"Widevine Content Decryption Module\":\"1.4.9.1076\"}},\"HTTP_HEADER\":{ \"user-agent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36\"},\"MESC\":{ \"MESC\":\"664678\"},\"OS_BROWSER\":{ \"build_id\":\"20030107\",\"cookie_enabled\":\"1\",\"vendor\":\"Google Inc.\",\"vendor_sub_id\":\"\",\"os\":\"Windows\",\"os_ver\":\"13.0.0\",\"browser_ver\":\"66.0.3359.170\",\"browser\":\"Chrome\"},\"SCREEN\":{ \"availHeight\":\"826\",\"availWidth\":\"1536\",\"colorDepth\":\"24\",\"height\":\"864\",\"width\":\"1536\",\"pixelDepth\":\"24\"},\"SYSTEM\":{ \"platform\":\"Win32\"},\"USER_PREF\":{ \"timezone\":\"-330\",\"sys_lang\":\"en-US\"}}}', 'oLdqFGWvuMkpgLS4+OLlveiHE5s3XeBd0R2eMkrpdXj76OWiNjswRE67lw4PABCD', '155.35.122.4', '10.131.158.233', 'GDP=TRANSPORT_EXCEPTION;', '2', '20', '0', '0', '0', '0', '111389', '0', '0', 'GOHL3eicIx7Z+OuNCrnJav6FaIxzyTmY7FRY+92RCkxhyjISRVW7og==', '5.10.0.0', '1');";
		return query;
	}
	
	private static String getRA3dsInsertQuery(String txnId) {
		String query = null;
		query = "INSERT INTO ARRFSYSAUDITLOG_3DSECURE (INSTANCEID, TXID, SESSIONID, CALLERID, TXNTYPE, STATUS, ORGNAME, CONFIGVERSION, CHANNELNAME, USERNAME, DEVICESIGNATURE, DEVICEIDOUT, CLIENTIPADDRESS, SDKIPADDRESS, SCORE, ADVICEID, RESULT_USERKNOWN, RESULT_TRUSTEDIP, RESULT_TRUSTEDAGGREGATOR, RESULT_ADDONRULES, RESULT_DETAIL, FRAUDSTATUS, MERCHANT_ID, MERCHANT_NAME, RAW_AMOUNT, AMOUNT, CURR_CODE, EXPONENT, USERREFID, USERASIS, DEVICETYPE, DEVICEIDSTATUS, DEVICEALIASOUT, DEVICEALIASSTATUS, METHODTYPE) VALUES ('15',";
		query += "'"+txnId+"', '15:50447', 'aadad', '1', '0', 'DEFAULTORG', '65', '3DSECURE', 'LXCLRAK0CQOITM3/1FXI4SZSYWA8+EQIQNQXNFITDYJYM/CEE4H+EW==', '{\"DEVICESIG\":{\"VERSION\":\"5.0\", \"EXTERNALIP\":{ \"externalip\":\"\"},\"EXTRA\":{ \"NetscapePlugins\":{\"Chrome PDF Viewer\":\"\",\"Native Client\":\"\",\"Widevine Content Decryption Module\":\"1.4.8.970\"}},\"HTTP_HEADER\":{ \"user-agent\":\"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36\"},\"OPTIONAL\":{ \"flash_ver\":\"29.0\"},\"OS_BROWSER\":{ \"build_id\":\"20030107\",\"cookie_enabled\":\"1\",\"vendor\":\"Google Inc.\",\"vendor_sub_id\":\"\",\"os\":\"Windows\",\"os_ver\":\"13.0.0\",\"browser_ver\":\"57.0.2987.133\",\"browser\":\"Chrome\"},\"SCREEN\":{ \"availHeight\":\"1040\",\"availWidth\":\"1920\",\"colorDepth\":\"24\",\"height\":\"1080\",\"width\":\"1920\",\"pixelDepth\":\"24\"},\"SYSTEM\":{ \"platform\":\"Win32\"},\"USER_PREF\":{ \"timezone\":\"-330\",\"sys_lang\":\"en-US\"}}}', 'w+NsJfw9ECqqQGdJTJ4RQZaQMuE+BSAiJPIeFVhSn8KjWIdIP2HTuLstLsVHHLgZ', '10.138.159.81', '155.35.144.173', '65', '4', 'Y', 'N', 'N', 'USERKNOWN=Y;EXCEPTION=N;UNTRUSTEDIP=N;TRUSTEDIP=N;SIGMATCH=N;SIGMATCHDEVICEALIAS=N;USERVELOCITY=Y;DEVICEIDCHECK=N;DEVICEVELOCITY=N;USERDEVICEASSOCIATED=N;AMNTCHKALLOW=N;AMNTCHKINCREASEAUTH=Y;AMNTCHKALERT=N;AMNTCHKDENY=N;DEVICEID_2_LAST1=N;', 'USERKNOWN=Y;EXCEPTION=N;UNTRUSTEDIP=N;TRUSTEDIP=N;SIGMATCH=N;SIGMATCHDEVICEALIAS=N;USERVELOCITY=Y;DEVICEIDCHECK=N;DEVICEVELOCITY=N;USERDEVICEASSOCIATED=N;AMNTCHKALLOW=N;AMNTCHKINCREASEAUTH=Y;AMNTCHKALERT=N;AMNTCHKDENY=N;DEVICEID_2_LAST1=N;', '0', '01234567890-1234', 'GOLSHOP3DS', '4599', '45.99', '840', '2', '111182', 'LxClrAk0CqoItM3/1FXI4SzsYWa8+eQiQNqxnFItdyjyM/cEe4H+ew==', '1', '0', 'nRRU5DVcWHY3V7mLQ4BpbG2WsDHJdh0x0e58i9nP/TCMATep/IXUTrHrI8r5hUY0', '0', '1');";
		return query;
	}
}
