package pl.spot.dbk.points.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.MetaObject;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.UserService;

@Transactional
public class HibUserService extends AbstractHibService implements UserService {

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
            session().merge(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public int create(User user) {
        return (Integer) session().save(user);
    }

    @Override
    public void clearSession() {
        session().clear();
    }

    @Override
    public List<MetaObject> listAsMetaObject() throws Exception {
        ArrayList<MetaObject> ret = new ArrayList<MetaObject>();
        
        for(User u : list()){
            ret.add(u.getMetaObject());
        }
        
        return ret;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> list() {
        return session().createCriteria(User.class).list();
    }
}
