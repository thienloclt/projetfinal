package monprojet.artiste.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "album_tbl")
public class Album {
	
	@Id
	@GeneratedValue
	@JsonView(View.Common.class)
	private Long id;

	@JsonView(View.Common.class)
	private String titre;
	
	@JsonView(View.Common.class)
	private Integer nbPiste;

	@ManyToMany(fetch = FetchType.EAGER)
	@JsonView(View.Artiste.class)
	private List<Artiste> artistes = new ArrayList<>();

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sacem_code")
	@JsonView(View.Sacem.class)
	private Sacem sacem;

	public Album() {
		super();
	}

	public Album(String titre, Integer nbPiste) {
		super();
		this.titre = titre;
		this.nbPiste = nbPiste;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getNbPiste() {
		return nbPiste;
	}

	public void setNbPiste(Integer nbPiste) {
		this.nbPiste = nbPiste;
	}

	public List<Artiste> getArtistes() {
		return artistes;
	}

	public void setArtistes(List<Artiste> artistes) {
		this.artistes = artistes;
	}

	public Sacem getSacem() {
		return sacem;
	}

	public void setSacem(Sacem sacem) {
		this.sacem = sacem;
	}
}
