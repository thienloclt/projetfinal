package monprojet.factory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Planning")
public class Planning {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; // peut etre à changer en Integer, penser aussi au changement à faire pour faire
					// l'appel lors de la creation du tableau

	@Column
	private String formateur;
	
	@Column
	private String titreFormateur;
	
	@Column
	private String couleur;

	@Column
	private String nom;

	@Column
	private Integer duree;
	
	@Column
	private Integer ordre;

	public String getFormateur() {
		return formateur;
	}

	public void setFormateur(String formateur) {
		this.formateur = formateur;
	}

	public String getTitreFormateur() {
		return titreFormateur;
	}

	public void setTitreFormateur(String titreFormateur) {
		this.titreFormateur = titreFormateur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	public int getId() {
		return id;
	}

	public Planning() {
		super();
	}

	public Planning(String formateur, String titreFormateur, String couleur, String nom, Integer duree,
			Integer ordre) {
		super();
		this.formateur = formateur;
		this.titreFormateur = titreFormateur;
		this.couleur = couleur;
		this.nom = nom;
		this.duree = duree;
		this.ordre = ordre;
	}

}
