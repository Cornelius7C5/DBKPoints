package pl.spot.dbk.points.server.service.impl;

import java.util.List;

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
    public Order create(Order o) {
        int id = (Integer) session().save(o);
        return (Order) get(id);
    }

    @Override
    public Order get(int id) {
        return (Order) session().get(Order.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> list() {
        return (List<Order>) session().createCriteria(Order.class).list();
    }

}
