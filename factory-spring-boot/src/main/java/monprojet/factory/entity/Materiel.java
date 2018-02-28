package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@Table(name = "materiel_tbl")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Materiel {
	
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
	private String code;
	
	@Size(min = 3)
	@NotNull
	@Column
	@JsonView(View.Common.class)
	private String nom;

	@ManyToMany(mappedBy = "materiels", fetch = FetchType.EAGER)
	@JsonView(View.FormationJSON.class)
	private Set<Formation> formations = new HashSet<Formation>();

	public Materiel() {
		super();
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

	public Materiel(@Size(min = 3) @NotNull String code, @Size(min = 3) @NotNull String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

}
