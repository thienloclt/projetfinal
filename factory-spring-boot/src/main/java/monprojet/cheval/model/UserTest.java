package monprojet.cheval.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@Table(name = "usertest_tbl")
public class UserTest {

	@Id
	@GeneratedValue
	@JsonView(View.Common.class)
	private Long id;

	@Version
	private int version;

	@JsonView(View.Common.class)
	@Email
	private String email;

	@JsonView(View.Common.class)
	@Size(min = 3)
	private String passwrd;

	public UserTest() {
		super();
	}

	public UserTest(String email, String passwrd) {
		super();
		this.email = email;
		this.passwrd = passwrd;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}
}
