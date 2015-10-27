package cat.cbcic.web.lao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cat.cbcic.web.dao.DAONoticies;
import cat.cbcic.web.models.Noticia;

@Component 
public class LAONoticies {

	@Autowired 
	private DAONoticies daoNoticies;
	
	public static final int NUM_NOTICIES_HOME = 2;
	public static final int NUM_NOTICIES = 6;
	
	public Noticia getNoticiaById(int idNoticia) {		
		Noticia noticia = daoNoticies.getNoticiaById(idNoticia);
		return noticia;
	}

	public Noticia getHomeNoticia() {
		Noticia noticia = daoNoticies.getHomeNoticia();
		return noticia;
	}

	public List<Noticia> getLastNNoticiesWithoutNoticia(int idNoticia, int numNoticies) {
		List<Noticia> noticiesList = daoNoticies.getLastNNoticiesWithoutNoticia(idNoticia, numNoticies);
		return noticiesList;
	}

	public List<Noticia> getPaginaN(int pagina, boolean isCronica) {
		List<Noticia> noticiesList = daoNoticies.getPaginaNNoticies(pagina, isCronica);
		return noticiesList;
	}

	public long getTotalPagines(boolean isCronica) {
		long noticies = daoNoticies.countAllNoticies(isCronica);		
		long totalpagines = noticies / LAONoticies.NUM_NOTICIES;
		if (noticies % LAONoticies.NUM_NOTICIES > 0) {
			totalpagines++;
		}		
		return totalpagines;
	}

	public List<Noticia> getNoticiesByOwner(String user) {
		List<Noticia> noticiesList = daoNoticies.getNoticiesByOwner(user);
		return noticiesList;
	}

    public List<Noticia> getAllNoticies() {
        List<Noticia> noticiesList = daoNoticies.getAllNoticies();
        return noticiesList;
    }

	public boolean crearNoticia(Noticia noticia){



		return daoNoticies.crearNoticia(noticia);
	}

	public boolean updateNoticia(Noticia noticia){
		return daoNoticies.updateNoticia(noticia);
	}

	public boolean deleteNoticia(Noticia noticia){
		return daoNoticies.deleteNoticia(noticia);
	}
}
