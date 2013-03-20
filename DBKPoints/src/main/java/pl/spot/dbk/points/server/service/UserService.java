package pl.spot.dbk.points.server.service;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import pl.spot.dbk.points.MetaObject;
import pl.spot.dbk.points.server.hib.User;

@Service
public interface UserService {
    public User get(Object id);

    public boolean update(User user);

    public void create(User user);

    public void clearSession();

    public List<MetaObject> listAsMetaObject() throws Exception;

    public List<User> list();

    public int getPoints(String id);

    public Transaction startTransaction();

}
