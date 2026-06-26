package busReserve;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static final String url="jdbc:mysql://localhost:3306/BusReserve";
	private static final String user = "root";
	private static final String password = "1234";
	
	public static Connection getConnection() throws Exception {
	    return DriverManager.getConnection(url, user, password);
	}
	
}
