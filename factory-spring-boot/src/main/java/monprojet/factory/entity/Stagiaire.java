package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@DiscriminatorValue(value = "Stagiaire")
public class Stagiaire extends Personne {
	
	@OneToMany(mappedBy = "stagiaire", fetch = FetchType.EAGER)
	@JsonView(View.AllocationJSON.class)
	private Set<Allocation> allocations = new HashSet<Allocation>();

	public Stagiaire() {
		super();
	}

	public Set<Allocation> getAllocations() {
		return allocations;
	}

	public void setAllocations(Set<Allocation> allocations) {
		this.allocations = allocations;
	}

}
