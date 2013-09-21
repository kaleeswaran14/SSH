package eu.strutters.example.todo.service;

import javax.inject.Named;

import eu.strutters.example.todo.model.Address;

/**
 * TodoItemService.
 *
 * @author Rene Gielen
 */
@Named
public class AddressService extends GenericEntityService<Address, Integer> {

	@Override
	protected Class<Address> entityClass() {
		return Address.class;
	}

//	@SuppressWarnings("unchecked")
//	public List<String> findCategories(String term) {
//		Query query = getCurrentSession().createQuery("select distinct todo.category from TodoItem as todo where lower(todo.category) like :term");
//		query.setString("term", "%" + term.toLowerCase() + "%");
//		return (List<String>) query.list();
//	}
	
}
