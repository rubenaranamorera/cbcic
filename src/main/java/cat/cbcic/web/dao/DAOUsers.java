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


    public boolean isSuperAdmin(String user){

        Connection con = null;

        boolean isSuperUser = false;

        try {

            con = connectionCreator.getConnection();

            String query = "Select isSuperAdmin from users where user = '" + user + "'";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            if (result.next()){
               isSuperUser = result.getBoolean("isSuperAdmin");
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

        return isSuperUser;
    }


    public boolean createUser(String user, String password, boolean admin, boolean superAdmin, String email){

        Connection con = null;

        boolean created = false;

        try {

            con = connectionCreator.getConnection();

            String query = "Insert into users values ('" + user + "','" + password + "'," + admin + "," + superAdmin + ",'" + email + "')";
            Statement statement = con.createStatement();

            statement.executeUpdate(query);

            created = true;
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

        return created;
    }
}
