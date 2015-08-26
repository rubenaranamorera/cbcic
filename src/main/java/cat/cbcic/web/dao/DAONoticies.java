package cat.cbcic.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cat.cbcic.web.lao.LAOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cat.cbcic.web.lao.LAONoticies;
import cat.cbcic.web.models.Noticia;

@Component
public class DAONoticies {
	
	@Autowired 
	private ConnectionCreator connectionCreator;


	public Noticia getNoticiaById(int idNoticia) {

		Noticia noticia = new Noticia(); 
		Connection con = null;
		
		try{
			
			con = connectionCreator.getConnection();
			
			String query = "Select * from noticies where idNoticia =  " + idNoticia;		
			Statement statement = con.createStatement();			
			ResultSet result = statement.executeQuery(query);	
						
			if (result.next()) {					
				noticia = fillBeanNoticia(result);
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

		return noticia;
	}

	public Noticia getHomeNoticia() {
		Noticia noticia = new Noticia(); 
		Connection con = null;
		
		try{
			
			con = connectionCreator.getConnection();
			
			String query = "Select * from noticies where isPortada = true order by dataCreacio DESC LIMIT 1";		
			Statement statement = con.createStatement();	
			ResultSet result = statement.executeQuery(query);	
						
			if (result.next()) {
				noticia =  fillBeanNoticia(result);
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

		return noticia;
	}

	public List<Noticia> getLastNNoticiesWithoutNoticia(int idNoticia, int numNoticies) {
		
		List<Noticia> noticiesList = new ArrayList<Noticia>();
		Connection con = null;
		
		try{
			
			con = connectionCreator.getConnection();
			
			String query = "Select * from noticies where idNoticia != " + idNoticia + " order by dataCreacio DESC LIMIT " + numNoticies;		
			Statement statement = con.createStatement();			
			ResultSet result = statement.executeQuery(query);	
						
			while (result.next()) {
				noticiesList.add(fillBeanNoticia(result));
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
		
		return noticiesList;
	}
	
	
	public long countAllNoticies(boolean isCronica) {
		
		long noticies = 0;
		Connection con = null;

		try{			
			con = connectionCreator.getConnection();
			
			String query = "SELECT COUNT(*) FROM noticies where isCronica = " + isCronica;		
			Statement statement = con.createStatement();			
			ResultSet result = statement.executeQuery(query);	
									
			while (result.next()) {					
				noticies = result.getInt(1);
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

		return noticies;
	}

	public List<Noticia> getPaginaNNoticies(int pagina, boolean isCronica) {
		List<Noticia> noticiesList = new ArrayList<Noticia>();
		Connection con = null;
		
		try{
			
			con = connectionCreator.getConnection();
			
			int noticiesAnteriors = pagina * LAONoticies.NUM_NOTICIES;
			int noticiesPosteriors = noticiesAnteriors + LAONoticies.NUM_NOTICIES;
			
			String query = "Select * from noticies where isCronica = " + isCronica + " order by dataCreacio DESC LIMIT " + noticiesAnteriors + ", " + noticiesPosteriors;		
			Statement statement = con.createStatement();			
			ResultSet result = statement.executeQuery(query);	
						
			while (result.next()) {	
				noticiesList.add(fillBeanNoticia(result));
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
		
		return noticiesList;
	}

    public List<Noticia> getAllNoticies() {
        List<Noticia> noticiesList = new ArrayList<Noticia>();
        Connection con = null;

        try{

            con = connectionCreator.getConnection();
            String query = "Select * from noticies order by dataCreacio DESC";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                noticiesList.add(fillBeanNoticia(result));
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

        return noticiesList;
    }

	public List<Noticia> getNoticiesByOwner(String user) {
		List<Noticia> noticiesList = new ArrayList<Noticia>();
		Connection con = null;

		try{

			con = connectionCreator.getConnection();
			String query = "Select * from noticies where owner = \"" + user + "\" order by dataCreacio DESC";
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				noticiesList.add(fillBeanNoticia(result));
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

		return noticiesList;
	}






    public boolean crearNoticia(Noticia noticia){

        Connection con = null;

        boolean created = false;

        try{
            con = connectionCreator.getConnection();
            String query =
                    "Insert into noticies " +
                    "   (titol,resum,contingut,isCronica,isPortada,fotoUrl,keywords,dataCreacio,owner) " +
                    "   values (\"" + noticia.getTitol() + "\", \""
							+ noticia.getResum() + "\", \""
							+ LAOUtils.StringToHTMLConverter(noticia.getContingut()) + "\", "
                    		+ noticia.isCronica() + ", "
							+ noticia.isPortada() + ", \""
							+ noticia.getFotoUrl() + "\", \""
							+ noticia.getKeywords() + "\", SYSDATE(), \""
							+ noticia.getOwner() + "\")";

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

    public boolean updateNoticia(Noticia noticia){

        Connection con = null;

        boolean updated = false;
        try{
            con = connectionCreator.getConnection();
            String query =
                    "Update noticies set" +
                    "   titol = \"" + noticia.getTitol() +  "\"," +
                    "   resum = \"" + noticia.getResum() +  "\"," +
                    "   contingut = \"" + noticia.getContingut() +  "\"," +
                    "   isCronica = " + noticia.isCronica() +  "," +
                    "   isPortada = " + noticia.isPortada() +  "," +
                    "   fotoUrl = \"" + noticia.getFotoUrl() +  "\"," +
                    "   keywords = \"" + noticia.getKeywords() +  "\"," +
                    "   dataCreacio = SYSDATE()," +
                    "   owner = \"" + noticia.getOwner() +  "\"" +
                    "   where idNoticia = " + noticia.getIdNoticia();

            Statement statement = con.createStatement();
            statement.executeUpdate(query);
            updated = true;
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
        return updated;
    }

    public boolean deleteNoticia(Noticia noticia){

        Connection con = null;

        Boolean deleted = false;

        try{
            con = connectionCreator.getConnection();
            String query =
                    "Delete from noticies where idNoticia = " + noticia.getIdNoticia();

            Statement statement = con.createStatement();
            statement.execute(query);
            deleted = true;
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

        return deleted;
    }



    private Noticia fillBeanNoticia(ResultSet result) throws Exception{

		Noticia noticia = new Noticia();
		noticia.setIdNoticia(result.getInt("idNoticia"));
		noticia.setCronica(result.getBoolean("isCronica"));
		noticia.setDataCreacio(result.getDate("dataCreacio"));
		noticia.setFotoUrl(result.getString("fotoUrl"));
		noticia.setResum(result.getString("resum"));
		noticia.setContingut(result.getString("contingut"));
		noticia.setTitol(result.getString("titol"));
		noticia.setPortada(result.getBoolean("isPortada"));
		noticia.setKeywords(result.getString("keywords"));
		noticia.setOwner(result.getString("owner"));

        return noticia;
	}
}
