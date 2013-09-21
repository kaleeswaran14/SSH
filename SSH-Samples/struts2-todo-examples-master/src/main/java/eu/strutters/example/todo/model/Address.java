package eu.strutters.example.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "address", catalog = "cmsadt")
public class Address implements java.io.Serializable {
	private Integer uid;
	private String phoneNumber;
	private String street;
	private String city;
	private String country;
	private Customer customer;
	
	public Address() {
	}
	
	public Address(Integer uid, String street, String city, String country) {
		this.uid = uid;
		this.street = street;
		this.city = city;
		this.country = country;
	}
	
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "customer"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false)
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getStreet() {
		return street;
	}

	@Column(nullable = false, length = 100)
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(unique = true, nullable = false, length = 10)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [id=" + uid + ", street=" + street + ", city=" + city
				+ ", country=" + country + "]";
	}
}
