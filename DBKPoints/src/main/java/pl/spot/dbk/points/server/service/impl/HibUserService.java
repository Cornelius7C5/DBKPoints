package pl.spot.dbk.points.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.MetaObject;
import pl.spot.dbk.points.server.hib.Invoice;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.UserService;

@Transactional
public class HibUserService implements UserService {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
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
        session().clear();
        try {
            session().update(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void create(User user) {
        session().merge(user);
    }

    @Override
    public void clearSession() {
        session().clear();
    }

    @Override
    public List<MetaObject> listAsMetaObject() throws Exception {
        ArrayList<MetaObject> ret = new ArrayList<MetaObject>();

        for (User u : list()) {
            ret.add(u.getMetaObject());
        }

        return ret;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> list() {
        return session().createCriteria(User.class).list();
    }

    @Override
    public int getPoints(String id) {
        User u = (User) session().get(User.class, new Integer(id.toString()));
        int sum = 0;
        for (Invoice i : u.getInvoices()) {
            sum += i.getAmount();
        }
        return sum;
    }

}
