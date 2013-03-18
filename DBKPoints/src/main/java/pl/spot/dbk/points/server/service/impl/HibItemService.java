package pl.spot.dbk.points.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.MetaObject;
import pl.spot.dbk.points.server.hib.Item;
import pl.spot.dbk.points.server.service.ItemService;

@Transactional
public class HibItemService implements ItemService {
    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(Item item) {
        session().save(item);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Item> list() {
        return session().createCriteria(Item.class).list();
    }

    @Override
    public Item get(Object id) {
        return (Item) session().get(Item.class, new Integer(id.toString()));
    }

    @Override
    public ArrayList<MetaObject> listAsMetaObject() throws Exception {
        ArrayList<MetaObject> ret = new ArrayList<MetaObject>();
        for (Item i : list()) {
            ret.add(i.getMetaObject());
        }
        return ret;
    }

    @Override
    public void update(Item item) {
        session().update(item);
    }

}
