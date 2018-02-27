package monprojet.cheval.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "registre_tbl")
public class Registre {
	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	private String numero;
	
	@Temporal(TemporalType.DATE)
	private Date dateDelivrance;
	
	@OneToOne(mappedBy = "registre", fetch=FetchType.EAGER)
	private Cheval cheval;
	
	public Registre() {
		super();
	}

	public Registre(String numero, Date date) {
		super();
		this.numero = numero;
		this.dateDelivrance = date;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateDelivrance() {
		return dateDelivrance;
	}

	public void setDateDelivrance(Date dateDelivrance) {
		this.dateDelivrance = dateDelivrance;
	}

	public Cheval getCheval() {
		return cheval;
	}

	public void setCheval(Cheval cheval) {
		this.cheval = cheval;
	}

	@Override
	public String toString() {
		return "Registre [numero=" + numero + ", dateDelivrance=" + dateDelivrance + "]";
	}
	
	public String getFullInfo() {
		return this.numero + " " + this.dateDelivrance.toString();
	}
}
