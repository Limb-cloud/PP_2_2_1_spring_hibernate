package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Transactional
   public User getUserByCar(Integer series, String model) {
      Query<User> query = sessionFactory.getCurrentSession()
          .createQuery("from User where car.series = :param_series and car.model = :param_model", User.class);
      query.setParameter("param_series", series);
      query.setParameter("param_model", model);
      return query.getSingleResult();
   }

}
