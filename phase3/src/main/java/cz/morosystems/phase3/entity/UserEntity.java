package cz.morosystems.phase3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="USER2TABLE")
public class UserEntity {
     
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
	@NotNull(message= "Firstname should not be empty.")
	@Pattern(regexp="[a-zA-Z ]+", message="Firstname should have alphabetical characters only.")
    @Column(name="FIRSTNAME")
    private String firstname;
    
	@NotNull(message= "Lastname should not be empty.")
	@Pattern(regexp="[a-zA-Z ]+", message="Lastname should have alphabetical characters only.")
    @Column(name="LASTNAME")
    private String lastname;
    
	@Email(message="Email does not have correct format.")
    @Column(name="EMAIL")
    private String email;
    
	@Size(min=9, max=13, message="Length of Telephone number is not correct.")
	@Pattern(regexp="[+]?[0-9]+", message="Telephone does not have correct format. Please enter the numbers without spaces.")
    @Column(name="TELEPHONE")
    private String telephone;

	public Integer getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}