package cat.cbcic.web.dao;

import cat.cbcic.web.models.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class DAOUsers {
	
	@Autowired 
	private ConnectionCreator connectionCreator;


	public boolean checkUserAndPassword(String user, String password) {
        Connection con = null;

        boolean isValid = false;

        try {

            con = connectionCreator.getConnection();

            String query = "Select * from users where user = '" + user + "' and password = '" + password + "'";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            if (result.next()){
                isValid = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return isValid;
    }


}
