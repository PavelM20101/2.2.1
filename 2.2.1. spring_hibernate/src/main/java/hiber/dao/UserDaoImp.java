package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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
   @Override
   public User find(String model, int series) {
      User findUser = null;
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where car.series = :series and car.model = :model")
              .setParameter("model", model)
              .setParameter("series", series);
      List<User> users = query.getResultList();
      if (!users.isEmpty()){
         findUser = users.get(0);
      }
      return findUser;
   }
}

