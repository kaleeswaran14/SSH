package eu.strutters.example.todo.service;

import javax.inject.Named;

import eu.strutters.example.todo.model.Payment;

/**
 * TodoItemService.
 *
 * @author Rene Gielen
 */
@Named
public class PaymentService extends GenericEntityService<Payment, Integer> {

	@Override
	protected Class<Payment> entityClass() {
		return Payment.class;
	}

//	@SuppressWarnings("unchecked")
//	public List<String> findCategories(String term) {
//		Query query = getCurrentSession().createQuery("select distinct todo.category from TodoItem as todo where lower(todo.category) like :term");
//		query.setString("term", "%" + term.toLowerCase() + "%");
//		return (List<String>) query.list();
//	}
	
}
