package cat.cbcic.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cat.cbcic.web.models.StaffMember;

@Component
public class DAOStaff {
	
	@Autowired 
	private ConnectionCreator connectionCreator;
	
	public ArrayList<StaffMember> getStaffMembersByEquip(int idEquip) {
		
		ArrayList<StaffMember> staffMemberList = new ArrayList<StaffMember>();
		Connection con = null;
		
		try{
			
			con = connectionCreator.getConnection();
			
			String query = "Select * from staff where idEquip = " + idEquip + " order by carrec asc";		
			Statement statement = con.createStatement();			
			ResultSet result = statement.executeQuery(query);	
						
			while (result.next()) {					
				StaffMember staffMember = new StaffMember();
				staffMember.setIdStaff(result.getInt("idStaff"));
				staffMember.setNom(result.getString("nom"));
				staffMember.setCognom1(result.getString("cognom1"));
				staffMember.setCognom2(result.getString("cognom2"));
				staffMember.setDni(result.getString("dni"));
				staffMember.setEquip(result.getInt("idEquip"));
				staffMember.setTelefon(result.getString("telefon"));
				staffMember.setCarrec(result.getString("carrec"));
				staffMember.setFotoUrl(result.getString("fotourl"));
				staffMember.setDataNaixement(result.getString("dataNaixement"));
				staffMember.setAnysClub(result.getInt("anysClub"));
				staffMember.setEmail(result.getString("email"));
				staffMemberList.add(staffMember);
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

		return staffMemberList;
	}
}
