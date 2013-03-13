package pl.spot.dbk.points.server.service.impl;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.server.hib.Item;
import pl.spot.dbk.points.server.service.ItemService;

@Transactional
public class HibItemService extends AbstractHibService implements ItemService {

    @Override
    public void create(Item item) {
        Transaction tx = session().beginTransaction();
        session().save(item);
        tx.commit();
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

}
