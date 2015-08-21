package cat.cbcic.web.models;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;

public class Noticia {

	private int idNoticia;
	private String titol;
	private String resum;
	private String contingut;
	private String fotoUrl;
	private Date dataCreacio;
	private boolean isCronica;
	private boolean isPortada;
	private String keywords;
    private String owner;
	private String dia;
	private String mes;
	private String any;
	private String timeAgo;
	
	
	public int getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
	public String getTitol() {
		return titol;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	public String getResum() {
		return resum;
	}
	public void setResum(String resum) {
		this.resum = resum;
	}
	public String getContingut() {
		return contingut;
	}
	public void setContingut(String contingut) {
		this.contingut = contingut;
	}
	public String getFotoUrl() {
		return fotoUrl;
	}
	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	public Date getDataCreacio() {
		return dataCreacio;
	}
	public void setDataCreacio(Date dataCreacio) {
		this.dataCreacio = dataCreacio;
	}
	public boolean isCronica() {
		return isCronica;
	}
	public void setCronica(boolean isCronica) {
		this.isCronica = isCronica;
	}
	public boolean isPortada() {
		return isPortada;
	}
	public void setPortada(boolean isPortada) {
		this.isPortada = isPortada;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
    public String getOwner() {return owner;}
    public void setOwner(String owner) { this.owner = owner;}
	public String getDia() {		
		if (dia!=null && !"".equals(dia)){
			return dia;
		}
		else{
			Calendar cal = Calendar.getInstance();
			cal.setTime(dataCreacio);			
			dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		}		
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMes() {
		if (mes!=null && !"".equals(mes)){
			return mes;
		}
		else{
			Calendar cal = Calendar.getInstance();
			cal.setTime(dataCreacio);			
			int mesNum = cal.get(Calendar.MONTH);
			
			switch(mesNum){
			case 0:
				mes = "Gener";		
				break;
			case 1:
				mes = "Febrer";
				break;
			case 2:
				mes = "Març";			
				break;
			case 3:
				mes = "Abril";
				break;
			case 4:
				mes = "Maig";	
				break;
			case 5:
				mes = "Juny";
				break;
			case 6:
				mes = "Juliol";	
				break;
			case 7:
				mes = "Agost";
				break;
			case 8:
				mes = "Setembre";	
				break;
			case 9:
				mes = "Octubre";
				break;
			case 10:
				mes = "Novembre";	
				break;
			case 11:
				mes = "Desembre";
				break;
			default: 
				mes = "";
				break;
			}
		}
		
		return mes;
	}
		
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public String getAny() {
		
		if (any!=null && !"".equals(any)){
			return any;
		}
		else{
			Calendar cal = Calendar.getInstance();
			cal.setTime(dataCreacio);			
			any = String.valueOf(cal.get(Calendar.YEAR));
		}		
		return any;
	}
	
	public void setAny(String any) {
		this.any = any;
	}
	
	public String getTimeAgo() {
				
		long time = System.currentTimeMillis() - dataCreacio.getTime();
		
		System.out.println("CurrentTimeMillis: " + System.currentTimeMillis());
		System.out.println("Data creació: " + dataCreacio.getTime());
		System.out.println("Time: " + time);
		
		if (time < (3600000 * 24)){
			timeAgo = "Fa menys d'un dia";
		}
		else if (time < (3600000 * 24 * 7)){
			int dies = (int)(time / (3600000 * 24));
			if (dies == 1){
				timeAgo = "Fa " + dies + " dia";
			}
			else{
				timeAgo = "Fa " + dies + " dies";
			}
		}
		else if (time < (3600000 * 24 * 30)){
			timeAgo = "Fa més d'una setmana";
		}
		else {
			timeAgo = "Fa més d'un mes";
		}
		
		
		try {
			timeAgo = new String(timeAgo.getBytes(), "UTF-8" );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeAgo;
	}
	public void setTimeAgo(String timeAgo) {
		this.timeAgo = timeAgo;
	}		
}
