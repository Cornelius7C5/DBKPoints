package pl.spot.dbk.points.server.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
        User u;
        Integer parsedId = 0;

        if (!(id instanceof UserDetails)) {
            parsedId = new Integer(id.toString());
        } else {
            parsedId = new Integer(((UserDetails) id).getUsername());
        }
        u = (User) session().get(User.class, parsedId);
        return u;
    }

    @Override
    public boolean update(User user) {
        try {
            session().update(user);
        } catch (Exception e) {

            return false;
        }
        return true;
    }
}
