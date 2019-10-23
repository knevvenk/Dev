// Code originally from http://www.devdaily.com/blog/post/java/simple-https-example

import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import sun.net.www.protocol.https.DefaultHostnameVerifier;

public class JavaHttpsClient
{
  public static void main(String[] args) throws Exception
  {
	  
	 URL url =  new URL("https", "preview5.arcot.com", 443, "/identity-service/api/v1/");
	  System.out.println(url.toString());
    HttpsURLConnection.setDefaultHostnameVerifier(
        new DefaultHostnameVerifier()      );

//    int number_of_calls = Integer.parseInt(args[1]);
//    for( int i = 0; i < number_of_calls; i++ ) {
      test("https://commonconsole/identity-service/api/v1/token");
//    }
  }

  private static void test(String httpsURL) throws Exception
  {
    URL myurl = new URL(httpsURL);
    HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
    InputStream ins = con.getInputStream();
    InputStreamReader isr = new InputStreamReader(ins);
    BufferedReader in = new BufferedReader(isr);

    String inputLine;

    while ((inputLine = in.readLine()) != null)
    {
      System.out.println(inputLine);
    }

    in.close();
    con.disconnect();
  }
}
