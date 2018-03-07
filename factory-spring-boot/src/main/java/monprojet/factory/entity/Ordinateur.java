package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@DiscriminatorValue(value = "Ordinateur")
public class Ordinateur extends Materiel {
	
	@Column
	@JsonView(View.Common.class)
	private String processeur;
	
	@Column
	@JsonView(View.Common.class)
	private String ram;
	
	@Column
	@JsonView(View.Common.class)
	private String disqueDur;
	
	@Column
	@JsonView(View.Common.class)
	private Integer anneeAchat;
/*--------------------------------------------------------------------------*/
	@JsonView(View.FormationJSON.class)
	@ManyToMany(mappedBy = "ordinateurs", fetch = FetchType.EAGER)
	Set<Formation> formations = new HashSet<Formation>();
	
	public Ordinateur() {
		super();
	}
	
	public Ordinateur(@Size(min = 3) @NotNull String code, @Size(min = 3) @NotNull String nom, Integer coutJournalier) {
		super(code, nom, coutJournalier);
		// TODO Auto-generated constructor stub
	}

	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getDisqueDur() {
		return disqueDur;
	}

	public void setDisqueDur(String disqueDur) {
		this.disqueDur = disqueDur;
	}

	public Integer getAnneeAchat() {
		return anneeAchat;
	}

	public void setAnneeAchat(Integer anneeAchat) {
		this.anneeAchat = anneeAchat;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

}
