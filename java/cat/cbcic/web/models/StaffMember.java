package cat.cbcic.web.models;

public class StaffMember {

	private int idStaff;
	private String nom;
	private String cognom1;
	private String cognom2;
	private String dni;
	private int equip;
	private String telefon;
	private String carrec;
	private String fotoUrl;
	private String dataNaixement;
	private int anysClub;
	private String email;
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCognom1() {
		return cognom1;
	}
	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}
	public String getCognom2() {
		return cognom2;
	}
	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}	
	public int getEquip() {
		return equip;
	}
	public void setEquip(int equip) {
		this.equip = equip;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}	
	public String getFotoUrl() {
		return fotoUrl;
	}
	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	public String getCarrec() {
		return carrec;
	}
	public void setCarrec(String carrec) {
		this.carrec = carrec;
	}
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	public String getDataNaixement() {
		return dataNaixement;
	}
	public void setDataNaixement(String dataNaixement) {
		this.dataNaixement = dataNaixement;
	}
	public int getAnysClub() {
		return anysClub;
	}
	public void setAnysClub(int anysClub) {
		this.anysClub = anysClub;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
