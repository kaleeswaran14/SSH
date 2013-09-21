package eu.strutters.example.todo.model;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.util.StrutsUtil;

import javax.persistence.*;
import java.util.Date;

//@Entity
public class CustomerTem {

	private Integer customerId;
	private String name;
	private String address;
	private Date createdDate;

	public CustomerTem() {
	}

	public CustomerTem(String name, String address, Date createdDate) {
		this.name = name;
		this.address = address;
		this.createdDate = createdDate;
	}

//    @Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

//    @RequiredStringValidator(message = "Name is required!")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//        @Column(length = 1024)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//    @Temporal(TemporalType.DATE)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
