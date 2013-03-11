package pl.spot.dbk.points.server.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.UserService;

@Transactional
public class HibUserService implements UserService {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User get(Object id) {

        User u = (User) session().get(User.class, new Integer(id.toString()));

        return u;
    }

}
