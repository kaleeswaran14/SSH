package eu.strutters.example.todo.service;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import eu.strutters.example.todo.model.Customer;

/**
 * TodoItemService.
 *
 * @author Rene Gielen
 */
@Named
public class CustomerService extends GenericEntityService<Customer, Integer> {

	@Override
	protected Class<Customer> entityClass() {
		return Customer.class;
	}

//	@SuppressWarnings("unchecked")
//	public List<String> findCategories(String term) {
//		Query query = getCurrentSession().createQuery("select distinct todo.category from TodoItem as todo where lower(todo.category) like :term");
//		query.setString("term", "%" + term.toLowerCase() + "%");
//		return (List<String>) query.list();
//	}
	
	@SuppressWarnings("unchecked")
	public List<String> getCustomerByName( String name ) {
//        return getCurrentSession().getNamedQuery("Employee.getByName")
//                .setString("name", name)
//                .list();
//		@NamedQuery(name = "Employee.getByName",
//                query = "select anrede,nachname from Employee emp where benutzername=:name")
                
		Query query = getCurrentSession().createQuery("select distinct customer.name from Customer as customer name=:name");
		query.setString("name", name);
		return (List<String>) query.list();
    }
	
//	http://stackoverflow.com/questions/16891896/how-to-fetch-data-from-multiple-table-query-using-hibernate
//	http://kruders.com/hibernate/hibernate-criteria/
//        http://stackoverflow.com/questions/3381521/why-hibernate-perform-two-queries-for-eager-load-a-onetoone-bidirectional-assoc
	
//	http://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm
		
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerByPhoneNmber( String phoneNumber ) {
                System.out.println("Query Execution started ......................................... ");
            //		Query query = getCurrentSession().createQuery("select customer from Customer as customer, Address as address where address.phoneNumber=:phoneNumber");
//                            Query query = getCurrentSession().createSQLQuery("select customer from Customer as customer, Address as address where address.phoneNumber=:phoneNumber");
//            Customer customer = (Customer)getCurrentSession().createQuery("from Address address left join fetch address.customer where address.phoneNumber=:phoneNumber").setParameter("phoneNumber", phoneNumber).list().get(0);
//		query.setString("phoneNumber", phoneNumber);
//                List<Customer> customers = (List<Customer>) query.list();
                
    			Criteria criteria = getCurrentSession().createCriteria(Customer.class,"customer").createAlias("customer.address","address").add(Restrictions.like("address.phoneNumber", phoneNumber+"%"));
    			System.out.println("Executed query and going for list @@@@@@@@@@@@@@@@@@@@@@ ");
    		    List<Customer> resultList = criteria.list();
                
                System.out.println("Customers size : " + resultList.size());
		return resultList;
    }
}
