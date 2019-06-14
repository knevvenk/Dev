package cci;

//STEP 1. Import required packages
import java.sql.*;
import java.util.UUID;

public class JDBCExample {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@155.35.135.132:1521:GOUTAMA";

	// Database credentials
	static final String USER = "drmfmuser";
	static final String PASS = "dost1234";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();
			String query = null;
			for (int i = 0; i < 100000; i++) {
				String fmTxnId = UUID.randomUUID().toString();
				String CURRENT_TIMESTAMP = "CURRENT_TIMESTAMP";
				
				query = "insert into FM_AUDITLOG (FMTXNID, OPERATION, CLIENTTXNID, CLIENTSESSIONID, TENANTID, USERNAME, MASKED_USERNAME, METHODTYPE, CHANNEL, ACTION, REQUEST, RESPONSE, OPSTATUS, TXNSTATUS, TXNSTARTTIME, TXNENDTIME, PAYSECSVCTXNID, INSTANCEID, UPDATETIME) values(";
				query += "'"+fmTxnId+"', 1, '"+UUID.randomUUID().toString()+"', 'session', 'SAFEBANK_NETBANKING', 'aUhOFWYp/s9EamfXaJtVDFbIgE0GDI1d8OMh17+OTn/D0GRZFJgsSQ==', 'a***1', 'PUSH', 'BANKING', 'login', '{\"action\":\"login\",\"channel\":\"BANKING\"}', '{\"nextActions\":[{\"action\":\"NOTIFY\",\"data\":{\"riskAdvice\":\"INCREASEAUTH\",\"riskScore\":65,\"deviceId\":\"6ix6WloHmi1E66bzAoznbYl5Gp1ptcpXqoxlIXrRW0OvIniONyR6rUwN1OmZzgdj\"}}]}', 0, "
						+ "0, "+CURRENT_TIMESTAMP+", "+CURRENT_TIMESTAMP+", "+"'"+UUID.randomUUID().toString()+"', "+"'"+UUID.randomUUID().toString()+"', "+CURRENT_TIMESTAMP+")";
				stmt.executeUpdate(query);
//				
				query = "insert into FM_AUDITLOG (FMTXNID, OPERATION, CLIENTTXNID, CLIENTSESSIONID, TENANTID, USERNAME, MASKED_USERNAME, METHODTYPE, REQUEST, RESPONSE, OPSTATUS, TXNSTATUS, TXNSTARTTIME, TXNENDTIME, PAYSECSVCTXNID, INSTANCEID, UPDATETIME) values(";
				query += "'" + fmTxnId + "', 2, '" + UUID.randomUUID().toString()
						+ "', 'session', 'SAFEBANK_NETBANKING', 'aUhOFWYp/s9EamfXaJtVDFbIgE0GDI1d8OMh17+OTn/D0GRZFJgsSQ==', 'a***1', 'PUSH', '{\"authType\":\"SA\"}', '{\"nextActions\":[{\"action\":\"OTP_AUTH\",\"data\":{\"methods\":{\"push\":[{\"factorDisplayName\":\"Xiaomi Mi A1\",\"factorId\":\"266885d5-168d-46e2-8382-c987ce3866ed\",\"deliveryReq\":\"false\",\"status\":\"auth_initiated\"}]}}},{\"action\":\"OTP_SELECTION\",\"data\":{\"methods\":{\"sms\":[{\"factorDisplayName\":\"*********865\",\"factorId\":\"05e048f4-894f-4ea7-9ca3-665e6a27a855\"}],\"push\":[{\"factorDisplayName\":\"Adila’s iPhone\",\"factorId\":\"266885d5-168d-46e2-8382-c987ce3866ed\"}],\"email\":[{\"factorDisplayName\":\"axxxxxxxxxxxxxxa@broadcom.com\",\"factorId\":\"4f330223-73c8-4afb-a6e4-55d95a2d8459\"}]}}}]}', 0, "
						+ "0, " + CURRENT_TIMESTAMP + ", " + CURRENT_TIMESTAMP + ", " + "'"
						+ UUID.randomUUID().toString() + "', " + "'" + UUID.randomUUID().toString() + "', "
						+ CURRENT_TIMESTAMP + ")";
				stmt.executeUpdate(query);
				
				query = "insert into FM_AUDITLOG (FMTXNID, OPERATION, CLIENTTXNID, CLIENTSESSIONID, TENANTID, USERNAME, MASKED_USERNAME, METHODTYPE, REQUEST, RESPONSE, OPSTATUS, TXNSTATUS, TXNSTARTTIME, TXNENDTIME, PAYSECSVCTXNID, INSTANCEID, UPDATETIME) values(";
				query += "'"+fmTxnId+"', 3, '"+UUID.randomUUID().toString()+"', 'session', 'SAFEBANK_NETBANKING', 'aUhOFWYp/s9EamfXaJtVDFbIgE0GDI1d8OMh17+OTn/D0GRZFJgsSQ==', 'a***1', 'PUSH', '{\"authType\":\"SA\"}', '{\"authToken\":null,\"nextActions\":[{\"action\":\"INCREASEAUTH\",\"data\":null}]}', 0, "
						+ "0, "+CURRENT_TIMESTAMP+", "+CURRENT_TIMESTAMP+", "+"'"+UUID.randomUUID().toString()+"', "+"'"+UUID.randomUUID().toString()+"', "+CURRENT_TIMESTAMP+")";
				stmt.executeUpdate(query);
			}
//			sql = "INSERT INTO Registration " + "VALUES (101, 'Mahnaz', 'Fatma', 25)";
//			stmt.executeUpdate(sql);
//			sql = "INSERT INTO Registration " + "VALUES (102, 'Zaid', 'Khan', 30)";
//			stmt.executeUpdate(sql);
//			sql = "INSERT INTO Registration " + "VALUES(103, 'Sumit', 'Mittal', 28)";
//			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end JDBCExample
