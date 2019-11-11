import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://10.80.112.140:5432/dev_radb";
		Properties props = new Properties();
		props.setProperty("user","devrauser");
		props.setProperty("password","dost1234");
		props.setProperty("ssl","true");
		Connection conn = DriverManager.getConnection(url, props);
		
		PreparedStatement st = conn.prepareStatement("SELECT ID, CODE FROM ARRFADVICECODE");
		System.out.println(st.execute());
	}

}
