package monprojet.factory.Planning.util;


public class DateFormatee {
	private int date_jour ;
	private String nom_jour ;
	private String nom_mois_Maj;

	public DateFormatee() {
		this.date_jour = 0;
		this.nom_jour = "";
		this.nom_mois_Maj = "";
		
	}
	

	public DateFormatee(int date_jour, String nom_jour, String nom_mois_Maj) {
		super();
		this.date_jour = date_jour;
		this.nom_jour = nom_jour;
		this.nom_mois_Maj = nom_mois_Maj;
	}


	public int getDate_jour() {
		return date_jour;
	}

	public void setDate_jour(int date_jour) {
		this.date_jour = date_jour;
	}

	public String getNom_jour() {
		return nom_jour;
	}

	public void setNom_jour(String nom_jour) {
		this.nom_jour = nom_jour;
	}

	public String getNom_mois_Maj() {
		return nom_mois_Maj;
	}

	public void setNom_mois_Maj(String nom_mois_Maj) {
		this.nom_mois_Maj = nom_mois_Maj;
	}
	public String toString() {
		return this.date_jour + " " + this.nom_jour + " " + this.nom_mois_Maj;
	}
}
