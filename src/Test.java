import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * 
 * @author banve02
 *
 */
public class Test {

	private String aa;
	
	/*public static int solution(String S, int K) {

		String[] strArr = S.split(" ");
		if (strArr.length < 1)
			return -1;
		List<String> tempList = new ArrayList<>();
		String tempStr = strArr[0];
		for (int i = 1; i < strArr.length; i++) {
			if ((tempStr.length() + strArr[i].length() + 1) <= K) {
				tempStr = tempStr + " " + strArr[i];
			} else if (tempStr.length() <= K) {
				tempList.add(tempStr);
				tempStr = strArr[i];
			} else {
				tempStr = strArr[i];
			}
		}
		if (tempStr.length() <= K)
			tempList.add(tempStr);
		System.out.println(tempList.toString());
		if (tempList.size() > 0)
			return tempList.size();
		else
			return -1;
	}*/

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(System.getenv("test"));
		String[] arr = "".split(",");
		System.out.println(arr.length+" "+arr[0]);
		
		
				
//		
//		Map<String, String> map = null;
//		Map<String, String> map1 = new HashMap<>();
//		map1.put("test1", "test1");
//		try {
//			map.putAll(map1);
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//		}
//		System.out.println(map);
//		String data = "ABCD";
//		Test t = new Test();
//		t.setAa(data += "EFGH");
//		System.out.println(t.getAa());
		/*try {
			URL url = new URL("tcp", "10.10.10.10", -1, "/token-service/api/v1/tokenize");
			System.out.println(url.toString());
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		System.out.println(convertBinary(31));
		int[] ar = { 2, 4, 6, 3, 5 };
		System.out.println(countMoves(ar));
		System.out.println((char) 50);
		System.out.println(solution("SMSSMSSMS SMSSMSSMS", 4));

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		long time = cal.getTimeInMillis();
		System.out.println(time);
		System.out.println(System.currentTimeMillis());

		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++");

		String json = "{\"transaction_id\":\"tHOK8L+3QNmCkJ2ZN82BrgEHBwA\u003d\",\"client_app_id\":\"TM\",\"user_id\":\"r/tmYqdolq+8it2NSOf06604cHZSv7IUWmB1F9l1lBx2YNYWCWOdMA\u003d\u003d\",\"auth_type\":\"SA\",\"authminder_params\":{\"org_name\":\"SA ORG\",\"default_credential_profile\":\"SA ORG_USER_credential\",\"user_credential_profile\":\"SA ORG_USER_credential\"},\"user_factors\":{\"device_token\":\"eanZiBiUn_c:APA91bEbT3e55aKpKuesPdS0MWC70c34JKCgJTlzB41CZgoicAa-JKVg7ePBBq6Z1fGFb72R1Qrlu1oTI3rvmJpPuI8WFy37dUJGHtF4aMk36dotcxCnWKc7bfTp4oHM3AYZPegnRRea\"},\"push_message\":{\"title\":\"CA StrongAuthentication\",\"notification\":\"A transaction of USD 29.99 was conducted on golshop3ds at 4/16/2018 11:48:32 AM (UTC/GMT). To approve this transaction, click \u003cb\u003eYes\u003c/b\u003e.\",\"transaction_body\":\"\u003chtml\u003e\u003cbody\u003e\u003ccenter\u003e\u003cheader style\u003d\\\"font-size: 15px;\\\"\u003e\u003cb\u003eTransaction Details\u003c/b\u003e\u003c/header\u003e\u003ctable \u003e\u003ctr\u003e\u003ctd\u003eAccount Id : XXXX XXXX XXXX 1770\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eMerchant : \u003c/td\u003e\u003ctd\u003egolshop3ds\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eAmount :\u003c/td\u003e\u003ctd\u003e29.99 USD\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eDate : \u003c/td\u003e\u003ctd\u003e4/16/2018 11:48:32 AM (UTC/GMT)\u003c/td\u003e\u003c/tr\u003e\u003c/table\u003e\u003c/center\u003e\u003c/body\u003e\u003c/html\u003e\"},\"delivery_channel\":[\"PUSH\"]}";

		String myString = "r/tmYqdolq+8it2NSOf06604cHZSv7IUWmB1F9l1lBx2YNYWCWOdMA==";
		// String myString = "<html><body><center><header style=\"font-size:
		// 15px;\"><b>Transaction Details</b></header><table >";
		// String myString =
		// "\u003chtml\u003e\u003cbody\u003e\u003ccenter\u003e\u003cheader
		// style\u003d\\\"font-size: 15px;\\\"\u003e\u003cb\u003eTransaction
		// Details\u003c/b\u003e\u003c/header\u003e\u003ctable
		// \u003e\u003ctr\u003e\u003ctd\u003eAccount Id : XXXX XXXX XXXX
		// 1770\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eMerchant :
		// \u003c/td\u003e\u003ctd\u003egolshop3ds\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eAmount
		// :\u003c/td\u003e\u003ctd\u003e29.99
		// USD\u003c/td\u003e\u003c/tr\u003e\u003ctr\u003e\u003ctd\u003eDate :
		// \u003c/td\u003e\u003ctd\u003e4/16/2018 11:48:32 AM
		// (UTC/GMT)\u003c/td\u003e\u003c/tr\u003e\u003c/table\u003e\u003c/center\u003e\u003c/body\u003e\u003c/html\u003e";
		byte[] utf8Bytes = null;
		try {
			utf8Bytes = json.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text = new String(utf8Bytes, "UTF-8");
		System.out.println(text);

		System.out.println("==========================================");
		System.out.println(myFib(9));*/
	}

/*	private static int myFib(int n) {
		if (n == 0 || n == 1)
			return n;
		else
			return myFib(n - 1) + myFib(n - 2);
	}

	public static Date currentTime() {

		ZonedDateTime zdt = ZonedDateTime.now(ZoneOffset.UTC);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

		DateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

		String dateStr = zdt.format(formatter);

		Date utcDate = null;

		try {

			utcDate = format.parse(dateStr);

		} catch (ParseException e) {

		}

		return utcDate;

	}

	public static int convertBinary(int num) {
		int binary[] = new int[4];
		int index = 0;
		while (index < 4) {
			binary[index++] = num % 2;
			num = num / 2;
		}
		if (index < 4)
			return 0;
		else
			return binary[index - 1];

	}

	public static int countMoves(int[] ar) {
		int even = 0, evenFact = 1;
		int odd = 0, oddFact = 1;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 0)
				even++;
			else
				odd++;
		}

		for (int i = 1; i <= even; i++) {
			evenFact = evenFact * i;
		}
		for (int i = 1; i <= odd; i++) {
			oddFact = oddFact * i;
		}
		return evenFact * oddFact;

	}*/

}
