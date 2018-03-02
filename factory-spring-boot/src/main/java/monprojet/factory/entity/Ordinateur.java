package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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
	@OneToMany(mappedBy = "ordinateur", fetch = FetchType.EAGER)
	@JsonView(View.AllocationJSON.class)
	private Set<Allocation> allocations = new HashSet<Allocation>();
	
	public Ordinateur() {
		super();
	}

	public Ordinateur(String processeur, String ram, String disqueDur, int anneeAchat) {
		super();
		this.processeur = processeur;
		this.ram = ram;
		this.disqueDur = disqueDur;
		this.anneeAchat = anneeAchat;
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

	public Set<Allocation> getAllocations() {
		return allocations;
	}

	public void setAllocations(Set<Allocation> allocations) {
		this.allocations = allocations;
	}
}
