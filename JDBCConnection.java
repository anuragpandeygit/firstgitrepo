


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Simple Java Program to connect Oracle database by using Oracle JDBC thin driver
 * Make sure you have Oracle JDBC thin driver in your classpath before running this program
 * @author
 */
public class JDBCConnection {

	public static void main(String args[]) throws SQLException {
		//URL of Oracle database server
		String url = "jdbc:oracle:thin:@hkuanar2l:1521:thinkme";

		//properties for creating connection to Oracle database
		Properties props = new Properties();
		props.setProperty("user", "wbmstg4_3");
		props.setProperty("password", "wbmstg4_3");

		//creating connection to Oracle database using JDBC
		Connection conn = DriverManager.getConnection(url,props);

		String sql ="select sysdate as current_day from dual";

		//creating PreparedStatement object to execute query
		PreparedStatement preStatement = conn.prepareStatement(sql);

		ResultSet result = preStatement.executeQuery();

		while(result.next()){
			System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
		}
		System.out.println("done");

	}
}


