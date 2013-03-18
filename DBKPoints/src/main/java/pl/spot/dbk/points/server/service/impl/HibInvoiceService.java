package pl.spot.dbk.points.server.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.server.hib.Invoice;
import pl.spot.dbk.points.server.service.InvoiceService;

@Transactional
public class HibInvoiceService implements InvoiceService {
    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int getPointsByUser(Object id) {

        return 0;
    }

    @Override
    public void update(Invoice invoice) {
        session().merge(invoice);
    }

}
