package tp2package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	   private static DBConnection instance ;
	   private static Connection conn;
		String BDD = "ebooks";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "password";
	    

	   
	    private DBConnection() throws SQLException {
			conn=DriverManager.getConnection(url, user,passwd);
		}

	    
	    public Connection getConn() {
			return conn;
		}


		public static DBConnection getInstance() throws SQLException {
			if(instance == null) {
				instance = new DBConnection();
			}
			return instance;
		}
	
}
