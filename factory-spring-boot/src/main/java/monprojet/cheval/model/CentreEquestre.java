package monprojet.cheval.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@Table(name = "centreequestre_tbl")
public class CentreEquestre {
	
	@Id
	@GeneratedValue
	@JsonView(View.Common.class)
	private Long id;

	@Version
	private int version;

	@JsonView(View.Common.class)
	private String nom;
	
	@JsonView(View.Common.class)
	private String adresse;
	
	@JsonView(View.Common.class)
	private String codepostal;

	@OneToMany(mappedBy = "centreEquestre", fetch = FetchType.EAGER)
	@JsonView(View.Cheval.class)
	private List<Cheval> chevals = new ArrayList<Cheval>();

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	public CentreEquestre() {
		super();
	}

	public CentreEquestre(String nom, String adresse, String codepostal) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.codepostal = codepostal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public List<Cheval> getChevals() {
		return chevals;
	}

	public void setChevals(List<Cheval> chevals) {
		this.chevals = chevals;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}
