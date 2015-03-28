package cat.cbcic.web.lao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cat.cbcic.web.dao.DAOJugadors;
import cat.cbcic.web.models.Jugador;

@Component 
public class LAOJugadors {

	@Autowired 
	private DAOJugadors daoJugadors;
	
	public List<Jugador> getJugadorsByEquip(int idEquip) {
		
		ArrayList<Jugador> jugadorsList = daoJugadors.getJugadorsByEquip(idEquip);
		return jugadorsList;
	}
	
	
}
