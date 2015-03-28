package cat.cbcic.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cat.cbcic.web.models.Equip;

@Component
public class DAOEquips {
	
	@Autowired 
	private ConnectionCreator connectionCreator;

	public Equip getEquipById(int idEquip){
		
		Equip equip = new Equip();
		Connection con = null;
		
		try{
			
			con = connectionCreator.getConnection();
			
			String query = "Select * from equips where idEquip = " + idEquip ;		
			Statement statement = con.createStatement();			
			ResultSet result = statement.executeQuery(query);	
						
			if (result.next()) {			
				equip.setIdEquip(result.getInt("idEquip"));
				equip.setNom(result.getString("nomEquip"));
				equip.setCategoria(result.getString("categoria"));
				equip.setMasculi(result.getBoolean("masculi"));
				equip.setDiaJoc(result.getString("diaJoc"));
				equip.setHoraJoc(result.getString("horaJoc"));	
				equip.setFotoUrl(result.getString("fotoUrl"));
				equip.setCalendariUrl(result.getString("calendariUrl"));
				equip.setClassificacioUrl(result.getString("classificacioUrl"));
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
		
		return equip;
	}
		
}
