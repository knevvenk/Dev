import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 
 * @author banve02
 *
 */
public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String json = "{\"transaction_id\":\"tHOK8L+3QNmCkJ2ZN82BrgEHBwA\u003d\",\"client_app_id\":\"TM\",\"user_id\":\"r/tmYqdolq+8it2NSOf06604cHZSv7IUWmB1F9l1lBx2YNYWCWOdMA\u003d\u003d\",\"auth_type\":\"SA\",\"authminder_params\":{\"org_name\":\"SA ORG\",\"default_credential_profile\":\"SA ORG_USER_credential\",\"user_credential_profile\":\"SA ORG_USER_credential\"},\"user_factors\":{\"device_token\":\"eanZiBiUn_c:APA91bEbT3e55aKpKuesPdS0MWC70c34JKCgJTlzB41CZgoicAa-JKVg7ePBBq6Z1fGFb72R1Qrlu1oTI3rvmJpPuI8WFy37dUJGHtF4aMk36dotcxCnWKc7bfTp4oHM3AYZPegnRRea\"},\"push_message\":{\"title\":\"CA StrongAuthentication\",\"notification\":\"A transaction of USD 29.99 was conducted on golshop3ds at 4/16/2018 11:48:32 AM (UTC/GMT). To approve this transaction, click \u003cb\u003eYes\u003c/b\u003e.\",\"transaction_body\":\"\u003chtml\u003e\u003cbody\u003e\u003ccenter\u003e\u003cheader style\u003d\\\"font-size: 15px;\\\"\u003e\u003cb\u003eTransaction Details\u003c/b\u003e\u003c/header\u003e\u003ctable \u003e\u003ctr\u003e\u003ctd\u003eAccount Id : XXXX XXXX XXXX 1770\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eMerchant : \u003c/td\u003e\u003ctd\u003egolshop3ds\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eAmount :\u003c/td\u003e\u003ctd\u003e29.99 USD\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eDate : \u003c/td\u003e\u003ctd\u003e4/16/2018 11:48:32 AM (UTC/GMT)\u003c/td\u003e\u003c/tr\u003e\u003c/table\u003e\u003c/center\u003e\u003c/body\u003e\u003c/html\u003e\"},\"delivery_channel\":[\"PUSH\"]}";
				
		String myString = "r/tmYqdolq+8it2NSOf06604cHZSv7IUWmB1F9l1lBx2YNYWCWOdMA==";
//		String myString = "<html><body><center><header style=\"font-size: 15px;\"><b>Transaction Details</b></header><table >";
//		String myString = "\u003chtml\u003e\u003cbody\u003e\u003ccenter\u003e\u003cheader style\u003d\\\"font-size: 15px;\\\"\u003e\u003cb\u003eTransaction Details\u003c/b\u003e\u003c/header\u003e\u003ctable \u003e\u003ctr\u003e\u003ctd\u003eAccount Id : XXXX XXXX XXXX 1770\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eMerchant : \u003c/td\u003e\u003ctd\u003egolshop3ds\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eAmount :\u003c/td\u003e\u003ctd\u003e29.99 USD\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eDate : \u003c/td\u003e\u003ctd\u003e4/16/2018 11:48:32 AM (UTC/GMT)\u003c/td\u003e\u003c/tr\u003e\u003c/table\u003e\u003c/center\u003e\u003c/body\u003e\u003c/html\u003e";
	    byte[] utf8Bytes = null;
		try {
			utf8Bytes = json.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String text = new String(utf8Bytes,"UTF-8");
	    System.out.println(text);
	    
	    System.out.println("==========================================");
	    System.out.println(myFib(9));
	}
	
	private static int myFib(int n) {
		if(n == 0 || n == 1)
			return n;
		else
			return myFib(n-1)+myFib(n-2);
	}
}
