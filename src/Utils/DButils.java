package Utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DButils {
	//加载驱动，并建立数据库连接
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user";
			String user = "";
			String password = "";
			Connection conn = DriverManager.getConnection(url,user,password);
			return conn;
	}
}