package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImp() {
    }

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }


    @Override
    public User getUserCar(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u join fetch u.car c WHERE c.model = :model AND c.series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getSingleResult();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }


}
