package monprojet.factory.Planning.util;

public class jourFormation {
	private String mois;
	private String jour;
	private String indiceJour;
	private String matiere;
	private String formateur;
	private String titre;
	private String couleur;

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public jourFormation() {
		mois = "";
		jour = "";
		indiceJour = "";
		matiere = "";
		formateur = "";
		titre = "";
	}

	public jourFormation(String mois, String jour, String indiceJour, String matiere, String formateur, String titre, String couleur) {
		this.mois = mois;
		this.jour = jour;
		this.indiceJour = indiceJour;
		this.matiere = matiere;
		this.formateur = formateur;
		this.titre = titre;
		this.couleur = couleur;
	}

	public jourFormation(String mois, String jour, String indiceJour) {
		this.mois = mois;
		this.jour = jour;
		this.indiceJour = indiceJour;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getIndiceJour() {
		return indiceJour;
	}

	public void setIndiceJour(String indiceJour) {
		this.indiceJour = indiceJour;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getFormateur() {
		return formateur;
	}

	public void setFormateur(String formateur) {
		this.formateur = formateur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String toString() {
		return this.mois + " " + this.jour + " " + this.indiceJour + " " + this.matiere + " " + this.formateur + " "
				+ this.titre + " " + this.couleur;
	}
}
