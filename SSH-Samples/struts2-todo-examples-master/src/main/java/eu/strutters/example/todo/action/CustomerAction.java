package eu.strutters.example.todo.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;

import com.opensymphony.xwork2.ActionSupport;

import eu.strutters.example.todo.model.Address;
import eu.strutters.example.todo.model.Customer;
import eu.strutters.example.todo.model.Tickets;
import eu.strutters.example.todo.service.CustomerService;
import eu.strutters.example.todo.service.TicketService;

public class CustomerAction extends ActionSupport{

	private int uid;
	private String phoneNumber;
	private Customer customer = new Customer();
//	private Address address = new Address();
	List<Customer> customerList = new ArrayList<Customer>();
	
	@Inject
	private CustomerService customerService;
	
	@Inject
	private TicketService ticketService;
	
//	CustomerBo customerBo;
//	//DI via Spring
//	public void setCustomerBo(CustomerBo customerBo) {
//		this.customerBo = customerBo;
//	}

//	public Object getModel() {
//		return customer;
//	}
	
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	// search by customer phone number
	public String searchCustomer() throws Exception {
            System.out.println("phoneNumber > " + phoneNumber);
		if (StringUtils.isNotEmpty(phoneNumber)) {
			System.out.println("Phone nummber is available , going for the search !!! ");
			customerList = customerService.getCustomerByPhoneNmber(phoneNumber);
			System.out.println("customerList size => " + customerList.size());
		} else {
			customerList = customerService.findAll();
		}
		return "success";
	}
	
	//save customer
	public String addCustomer() throws Exception{
		System.out.println("ADDD customerId 23 ");
		//save it
//		customer.setCreatedDate(new Date());
//		customerBo.addCustomer(customer);
//	 
//		//reload the customer list
//		customerList = null;
//		customerList = customerBo.listCustomer();
		customer.setRegistrationDate(new Date());
		System.out.println("Address before => " + customer.getAddress());
		System.out.println("Going to set address id val => " + customer.getUid());
//		this is very very imortantC
		Address address = customer.getAddress();
		address.setUid(customer.getUid());
		
		customer.setAddress(address);
		address.setCustomer(customer);
		
		System.out.println("Address after => " + customer.getAddress());
		if (customer.getUid() != null && customer.getUid() > 0) {
			System.out.println("udation ****************..... ");
			customerService.merge(customer);
			
			// update tickets
			
			// update payments
			
		} else {
			System.out.println("adding *************** ..... ");
			Integer savedCustomerId = customerService.save(customer);
			System.out.println("savedCustomerId > " + savedCustomerId);
			
			// add Tickets
			Tickets ticket = new Tickets();
			ticket.setProblem("Not able to start the amchine. ");
			ticket.setRepairTye("office");
			ticket.setProblemFiledDate(new Date());
			ticket.setStatus("open");
			ticket.setStatusChangedDate(new Date());
			
			List<Tickets> tickets = new ArrayList<Tickets>();
			tickets.add(ticket);
			
			System.out.println("Tckets obj = > " + ticket);
			ticket.setCustomer(customer);
			customer.setTickets(tickets);
			ticketService.save(ticket);
			
			// add paymets
		}
		
//		customerList = customerService.findAll();
		return "success";
	
	}
	
	//list all customers
	public String listCustomer() throws Exception{
		
		System.out.println("todoItemService > " + customerService);
//		customerList = customerBo.listCustomer();
//		Criteria criteria = customerService.createCriteria();
		Criteria criteria = null;
		customerList = customerService.findAll();

		System.out.println("LIST customerId vlistCustomer " + customerList.size());
		return "success";
	}
        
        //Home page
	public String homePage() throws Exception{
		System.out.println("Home page ... ");
		return "success";
	}
        
        //New customer page
	public String newCustomer() throws Exception{
		System.out.println("newCustomer ... ");
		return "success";
	}

	public String customerHome() throws Exception{
		System.out.println("customerHome ... ");
		return "success";
	}
	
	//delete a customer
	public String deleteCustomer() throws Exception{
		System.out.println("deleet customerId > " + getUid());
//		customerBo.deleteCustomer(getCustomerId());
//		customerList = customerBo.listCustomer();
		Customer customerDel = customerService.get(getUid());
		System.out.println("customer to be deletable name " + customer.getName());
		customerService.delete(customerDel);
		
//		customerList = customerService.findAll();
		return "success";
	
	}
	
	//edit a customer
	public String editCustomer() throws Exception{
//		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		System.out.println("edit customerId > " + getUid());
		customer = customerService.get(getUid());
//		System.out.println("customerId > " + request.getParameter("id").toString());
//		customer = customerBo.getCustomer(getCustomerId());
		System.out.println("edit customer name => " +  customer.getName());
		System.out.println("edit customer id => " +  customer.getUid());
//		customerList = customerBo.listCustomer();
		customerList = customerService.findAll();
		return "success";
	
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

}