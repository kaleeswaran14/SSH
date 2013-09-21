package com.mkyong.stock;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer", catalog = "HibernateAnnotationExRQ")
public class Customer implements java.io.Serializable {

    private Integer uid;
    private String name;
    private Date registrationDate;
    private Address address;
    private List<Tickets> tickets = new ArrayList<Tickets>();
    
    public Customer() {
	}

	public Customer(Integer uid, String name, Date registrationDate,
			Address address) {
		super();
		this.uid = uid;
		this.name = name;
		this.registrationDate = registrationDate;
		this.address = address;
	}

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "uid", unique = true, nullable = false)
    public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

    @Column(nullable = false)
    public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, length = 10)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
	public List<Tickets> getTickets() {
		return tickets;
	}

	public void setTickets(List<Tickets> tickets) {
		this.tickets = tickets;
	}
}
