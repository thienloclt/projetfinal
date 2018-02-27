package monprojet.artiste.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "sacem_tbl")
public class Sacem {
	
	@Id
	@JsonView(View.Common.class)
	private String id; //code
	
	@Temporal(TemporalType.DATE)
	@JsonView(View.Common.class)
	private Date dateCreation;
	
	@OneToOne(mappedBy = "sacem", fetch=FetchType.EAGER)
	@JsonView(View.Album.class)
	private Album album;
	
	public Sacem() {
		super();
	}

	public Sacem(String id, Date dateCreation) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
}