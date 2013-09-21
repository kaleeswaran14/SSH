package com.mkyong.stock;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tickets", catalog = "HibernateAnnotationExRQ")
public class Tickets implements java.io.Serializable {
	private Integer ticketId;
	private String problem;
	private Date problemFiledDate;
	private String accessories;
	private String comments;
	private String repairTye; // office, home
	private Date statusChangedDate;
	private String status; //open, in-progress, fixed, deferred ... tobe-fixed, in-progress, fixed
	
	private Customer customer;
	
	private Payment payment;

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	@Column(nullable = false)
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, length = 10)
	public Date getProblemFiledDate() {
		return problemFiledDate;
	}

	public void setProblemFiledDate(Date problemFiledDate) {
		this.problemFiledDate = problemFiledDate;
	}

	public String getAccessories() {
		return accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(nullable = false)
	public String getRepairTye() {
		return repairTye;
	}

	public void setRepairTye(String repairTye) {
		this.repairTye = repairTye;
	}

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, length = 10)
	public Date getStatusChangedDate() {
		return statusChangedDate;
	}

	public void setStatusChangedDate(Date statusChangedDate) {
		this.statusChangedDate = statusChangedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uid", nullable = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "ticket", cascade = CascadeType.ALL)
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Tickets [ticketId=" + ticketId + ", problem=" + problem
				+ ", problemFiledDate=" + problemFiledDate + ", accessories="
				+ accessories + ", comments=" + comments + ", repairTye="
				+ repairTye + ", statusChangedDate=" + statusChangedDate
				+ ", status=" + status + ", customer=" + customer + "]";
	}
	
	
}
