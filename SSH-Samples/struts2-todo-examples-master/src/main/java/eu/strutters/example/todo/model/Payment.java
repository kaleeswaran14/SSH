package eu.strutters.example.todo.model;

import java.util.Date;

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
@Table(name = "payment", catalog = "cmsadt")
public class Payment implements java.io.Serializable {
	private Integer pid;
	private Integer amount;
	private String staus; // paid, not-paid, partially-paid
	private Date paymentDate;
	
	private Tickets ticket;
	
	public Payment() {
	}
	
	public Payment(Integer pid, Integer amount, String staus, Date paymentDate) {
		this.pid = pid;
		this.amount = amount;
		this.staus = staus;
		this.paymentDate = paymentDate;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "ticket"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false)
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getStaus() {
		return staus;
	}
	public void setStaus(String staus) {
		this.staus = staus;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Tickets getTicket() {
		return ticket;
	}

	public void setTicket(Tickets ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", amount=" + amount + ", staus="
				+ staus + ", paymentDate=" + paymentDate + "]";
	}
	
}
