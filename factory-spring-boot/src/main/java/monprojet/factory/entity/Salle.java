package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@Table(name = "salle_tbl")
public class Salle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(View.Common.class)
	private Long id;

	@Version
	private int version;
	
	@Size(min = 3)
	@NotNull
	@Column
	@JsonView(View.Common.class)
	private String nom;

	@OneToMany(mappedBy = "salle", fetch = FetchType.EAGER)
	@JsonView(View.FormationJSON.class)
	private Set<Formation> formations = new HashSet<Formation>();

	public Salle() {
		super();
	}
	
	public Salle(@Size(min = 3) @NotNull String nom) {
		super();
		this.nom = nom;
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

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
