/**
 * 
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Tuong Vy Luan
 *
 */
public class DBUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
	Connection connection = null;
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url = "jdbc:sqlserver://hehe.cfxbyhftx9ql.ap-southeast-1.rds.amazonaws.com:1433;databaseName=Hehe";
	connection = DriverManager.getConnection(url, "admin", "12345678");
	return connection;
    }
}
