
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class GMTDateUtil {
	
	private static SimpleDateFormat gmtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static {
		gmtFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	}
	
	public static Date getCurrentGMTDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
		Date date = cal.getTime();		
		return getGMTDate(date);
	}
	 
	public static Date getDaysBeforeGMTDate(int noOfDays) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -noOfDays);
		Date date = cal.getTime();
		return getGMTDate(date);
	}
	
	public static Date getGMTDate(Date date) {
		String gmtS = gmtFormat.format(date);		
		try {
			return dateFormat.parse(gmtS);
		} catch (ParseException e) {
			return date;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getCurrentGMTDate());
		System.out.println(getGMTDate(getCurrentGMTDate()));
	}
}
