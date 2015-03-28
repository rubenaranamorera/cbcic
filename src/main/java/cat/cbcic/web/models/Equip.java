package cat.cbcic.web.models;

public class Equip {

	private int idEquip;
	private String nom;
	private String categoria;
	private boolean masculi;
	private String diaJoc;
	private String horaJoc;
	private String fotoUrl;
	private String calendariUrl;
	private String classificacioUrl;
	
	public int getIdEquip() {
		return idEquip;
	}
	public void setIdEquip(int idEquip) {
		this.idEquip = idEquip;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean isMasculi() {
		return masculi;
	}
	public void setMasculi(boolean masculi) {
		this.masculi = masculi;
	}
	public String getDiaJoc() {
		return diaJoc;
	}
	public void setDiaJoc(String diaJoc) {
		this.diaJoc = diaJoc;
	}
	public String getHoraJoc() {
		return horaJoc;
	}
	public void setHoraJoc(String horaJoc) {
		this.horaJoc = horaJoc;
	}
	public String getFotoUrl() {
		return fotoUrl;
	}
	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	public String getCalendariUrl() {
		return calendariUrl;
	}
	public void setCalendariUrl(String calendariUrl) {
		this.calendariUrl = calendariUrl;
	}
	public String getClassificacioUrl() {
		return classificacioUrl;
	}
	public void setClassificacioUrl(String classificacioUrl) {
		this.classificacioUrl = classificacioUrl;
	}
		
}
