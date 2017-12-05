
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.PropertyConfigurator;


/**
 * 
 * @author banve02
 *
 * This Class will be called while initializing the ACSServletFilter and it will create log files different Authentication schemes
 */
public class FilterLogger{

	private String FILTERLOG4J_PROPERTIES = "FilterLog4j.properties";
	private final String ARCOT_HOME = "ARCOT_HOME";
	private final String FILTER_LOGS_FOLDER_PATH = "filterLogPath";
	private final String HOST_NAME = "hostName";
	private Logger logger;
	public static final String ACSFILTER_APPENDER = "acsservletfilter";
	public static final String MPN_TRANSACTION_APPENDER = "mpntransaction";
	public static final String MCID_TRANSACTION_APPENDER = "mcidtransaction";
	public static final String TTP_TRANSACTION_APPENDER = "ttptransaction";
	
	/**
	 * Load the log4j file from the WEB-INF/classes folder
	 * This will create the log files for ACSServletFilter, MobilePushNotification, TTPAuthentication, MCIDAuthentication
	 */
	public FilterLogger(){		
		String arcotHomePath = System.getenv(ARCOT_HOME);		
		System.setProperty(FILTER_LOGS_FOLDER_PATH, arcotHomePath+"/logs");
		Properties props = new Properties();
		try {
			props.load(getClass().getResourceAsStream("/"+FILTERLOG4J_PROPERTIES));
		} catch (IOException ioExc) {
			System.out.println("Exception while reading the "+FILTERLOG4J_PROPERTIES+" :: "+ioExc.getMessage());			
		} catch (Exception exc){
			System.out.println("Exception while creating the ACSServletFilter logs :: "+exc.getMessage());
		}
		PropertyConfigurator.configure(props);
	}
	
	public FilterLogger(String name){
		this.logger = Logger.getLogger(name);
	}
	
	public void logInfo(String message){
		MDC.put(HOST_NAME, getHostName());
		logger.info(message);
	}	
	
	public void logDebug(String message){
		if(isDebugEnabled()){
			MDC.put(HOST_NAME, getHostName());
			logger.debug(message);
		}
	}
	
	private boolean isDebugEnabled() {		
		if(logger.getLevel().toString().equalsIgnoreCase("DEBUG"))
			return true;
		else
			return false;
	}
	
	public void logError(String message){
		MDC.put(HOST_NAME, getHostName());
		logger.error(message);
	}
	
	public void logException(String message, Exception e){
		logError(message+" : Stack Trace : "+e.getStackTrace());
	}
	
	private String getHostName() {
		String hostName = null;
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.out.println("Error while getting the hostname");
		}
		return hostName;
	}
	
	
}
