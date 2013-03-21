package pl.spot.dbk.points.server.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.server.hib.Order;
import pl.spot.dbk.points.server.service.OrderService;

@Transactional
public class HibOrderService implements OrderService {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(Order o) {
        session().saveOrUpdate(o);
    }

}
