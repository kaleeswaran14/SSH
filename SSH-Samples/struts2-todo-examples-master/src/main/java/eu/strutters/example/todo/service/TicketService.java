package eu.strutters.example.todo.service;

import eu.strutters.example.todo.model.Customer;
import eu.strutters.example.todo.model.Tickets;
import eu.strutters.example.todo.model.TodoItem;
import org.hibernate.Query;

import javax.inject.Named;
import java.util.List;

/**
 * TodoItemService.
 *
 * @author Rene Gielen
 */
@Named
public class TicketService extends GenericEntityService<Tickets, Integer> {

	@Override
	protected Class<Tickets> entityClass() {
		return Tickets.class;
	}

//	@SuppressWarnings("unchecked")
//	public List<String> findCategories(String term) {
//		Query query = getCurrentSession().createQuery("select distinct todo.category from TodoItem as todo where lower(todo.category) like :term");
//		query.setString("term", "%" + term.toLowerCase() + "%");
//		return (List<String>) query.list();
//	}
	
}
