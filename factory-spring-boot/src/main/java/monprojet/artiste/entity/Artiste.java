package monprojet.artiste.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "artiste_tbl")
public class Artiste {
	
	@Id
	@JsonView(View.Common.class)
	private String nom_artiste;

	@JsonView(View.Common.class)
	private String nom;

	@JsonView(View.Common.class)
	private String prenom;
	
	@JsonView(View.Common.class)
	private String adresse;
	
	@Temporal(TemporalType.DATE)
	@JsonView(View.Common.class)
	private Date dateDeNaissance;

	@ManyToMany(mappedBy = "artistes", fetch = FetchType.EAGER)
	@JsonView(View.Album.class)
	private List<Album> albums = new ArrayList<>();

	public Artiste() {
		super();
	}

	public Artiste(String nom_artiste, String nom, String prenom, String adresse, Date dateDeNaissance) {
		super();
		this.nom_artiste = nom_artiste;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNom_Artiste() {
		return nom_artiste;
	}

	public void setNom_Artiste(String nom_artiste) {
		this.nom_artiste = nom_artiste;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
}
