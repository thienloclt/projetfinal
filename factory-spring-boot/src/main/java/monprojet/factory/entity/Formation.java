package monprojet.factory.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@Table(name = "formation_tbl")
public class Formation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(View.Common.class)
	private Integer id;

	@Version
	private int version;
	
	@Column
	@Size(min = 3)
	@NotNull
	@JsonView(View.Common.class)
	private String titre;
	
	@Column
	@NotNull
	@Temporal(TemporalType.DATE)
	@JsonView(View.Common.class)
	private Date dateDebut;
	
	@Column
	@NotNull
	@Temporal(TemporalType.DATE)
	@JsonView(View.Common.class)
	private Date dateFin;
/*-----------------------------------------------------------------------*/
	@ManyToOne
	@JoinColumn(name = "salle_id")
	@NotNull
	@JsonView(View.SalleJSON.class)
	private Salle salle;
	
	@ManyToOne
	@JoinColumn(name = "gestionnaire_id")
	@NotNull
	@JsonView(View.GestionnaireJSON.class)
	private Gestionnaire gestionnaire;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "formation_matiere_tbl", joinColumns = @JoinColumn(name = "formation_id"), inverseJoinColumns = @JoinColumn(name = "matiere_id"))
//	@NotNull
//	@JsonView(View.MatiereJSON.class)
//	private Set<Matiere> matieres = new HashSet<Matiere>();
	
	@OneToMany(mappedBy = "formation", fetch = FetchType.EAGER)
	@JsonView(View.ProgrammeJSON.class)
	private Set<Programme> programmes = new HashSet<Programme>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "formation_formateur_tbl", joinColumns = @JoinColumn(name = "formation_id"), inverseJoinColumns = @JoinColumn(name = "formateur_id"))
	@NotNull
	@JsonView(View.FormateurJSON.class)
	private Set<Formateur> formateurs = new HashSet<Formateur>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "formation_materiel_tbl", joinColumns = @JoinColumn(name = "formation_id"), inverseJoinColumns = @JoinColumn(name = "materiel_id"))
	@JsonView(View.MaterielJSON.class)
	private Set<Materiel> materiels = new HashSet<Materiel>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "formation_stagiaire_tbl", joinColumns = @JoinColumn(name = "formation_id"), inverseJoinColumns = @JoinColumn(name = "stagiaire_id"))
	@JsonView(View.MaterielJSON.class)
	private Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();

	public Formation() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public Set<Programme> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(Set<Programme> programmes) {
		this.programmes = programmes;
	}

	public Set<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(Set<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public Set<Materiel> getMateriels() {
		return materiels;
	}

	public void setMateriels(Set<Materiel> materiels) {
		this.materiels = materiels;
	}

	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
}
