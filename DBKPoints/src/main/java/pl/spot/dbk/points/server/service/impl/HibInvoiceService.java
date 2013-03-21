package pl.spot.dbk.points.server.service.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.MetaObject;
import pl.spot.dbk.points.server.hib.Invoice;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.InvoiceService;
import pl.spot.dbk.points.server.service.UserService;

@Transactional
public class HibInvoiceService implements InvoiceService {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private UserService userService;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int getPointsByUser(Object id) {
        User u = (User) userService.get(id);
        int sum = 0;
        for (Invoice i : u.getInvoices()) {
            sum += i.getAmount() + i.getExtra();
        }
        return sum;
    }

    @Override
    public void update(Invoice invoice) {
        session().update(invoice);
    }

    @Override
    public Invoice create(Invoice invoice) {
        int id = (Integer) session().save(invoice);
        return (Invoice) get(id);
    }

    @Override
    public ArrayList<MetaObject> listAsMetaObject() {
        ArrayList<MetaObject> ret = new ArrayList<MetaObject>();

        try {
            for (Invoice i : list()) {
                ret.add(i.getMetaObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Invoice> list() {
        return (ArrayList<Invoice>) session().createCriteria(Invoice.class).list();
    }

    @Override
    public Invoice get(int id) {
        return (Invoice) session().get(Invoice.class, id);
    }

}
