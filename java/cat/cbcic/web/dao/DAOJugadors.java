package cat.cbcic.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cat.cbcic.web.models.Jugador;

@Component
public class DAOJugadors {
	
	@Autowired 
	private ConnectionCreator connectionCreator;
	
	public ArrayList<Jugador> getJugadorsByEquip(int idEquip) {
		
		ArrayList<Jugador> jugadorsList = new ArrayList<Jugador>();
		Connection con = null;
		
		try{
			
			con = connectionCreator.getConnection();
			
			String query = "Select * from jugadors where idEquip = " + idEquip + " order by numero asc";		
			Statement statement = con.createStatement();			
			ResultSet result = statement.executeQuery(query);	
						
			while (result.next()) {					
				Jugador jugador = new Jugador();
				jugador.setIdJugador(result.getInt("idJugador"));
				jugador.setNom(result.getString("nom"));
				jugador.setCognom1(result.getString("cognom1"));
				jugador.setCognom2(result.getString("cognom2"));
				jugador.setDni(result.getString("dni"));
				jugador.setEquip(result.getInt("idEquip"));
				jugador.setTelefon(result.getString("telefon"));
				jugador.setNumero(result.getInt("numero"));
				jugador.setFotoUrl(result.getString("fotourl"));	
				jugador.setAltura(result.getInt("altura"));
				jugador.setDataNaixement(result.getString("dataNaixement"));
				jugador.setAnysClub(result.getInt("anysClub"));	
				jugador.setEmail(result.getString("email"));
				jugadorsList.add(jugador);
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

		return jugadorsList;
	}
}
