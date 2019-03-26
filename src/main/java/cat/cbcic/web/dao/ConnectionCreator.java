package cat.cbcic.web.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class ConnectionCreator {

  public Connection getConnection() {

    Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      //Openshift
      String host = System.getenv("MYSQL_SERVICE_HOST");
      String port = System.getenv("MYSQL_SERVICE_PORT");
      String username = System.getenv("MYSQL_USER");
      String password = System.getenv("MYSQL_PASSWORD");
      String databaseName = System.getenv("MYSQL_DATABASE");



      con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databaseName, username, password);

      //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbcic", "admin", "admin");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }
}
