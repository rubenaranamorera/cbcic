package cat.cbcic.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class ConnectionCreator {
	
	public Connection getConnection(){		
		
		Connection con = null; 		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//Openshift
			String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
			String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
			String username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
			String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port  +"/cbcic", username, password);	
			
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbcic", "admin", "admin");		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
