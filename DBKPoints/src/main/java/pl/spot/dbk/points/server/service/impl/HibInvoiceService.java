package pl.spot.dbk.points.server.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.spot.dbk.points.server.service.InvoiceService;

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

}
