package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.User;

public class UserDao extends GenericDao<User> {
	
	public User findByUsername(String username) {
		User user = new User();
		EntityManager em = getEntityManager();
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("select * from users where loginUser = :user");
			Query query = em.createNativeQuery(sb.toString(), User.class);
			query.setParameter("user", username);
			user = (User)query.getSingleResult();
			
			return user;
		}
		catch(Exception err) {
			err.printStackTrace();
			return user;
		}
		finally {
			em.close();
		}
	}
}
