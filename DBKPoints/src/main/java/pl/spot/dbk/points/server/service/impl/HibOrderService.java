package pl.spot.dbk.points.server.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.server.hib.Basket;
import pl.spot.dbk.points.server.hib.Order;
import pl.spot.dbk.points.server.service.OrderService;
import pl.spot.dbk.points.server.service.StatusService;

@Transactional
public class HibOrderService implements OrderService {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private StatusService statusService;

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
        Order o = (Order) session().get(Order.class, id);
        Hibernate.initialize(o.getBasketItems());
        int sum = 0;
        for (Basket b : o.getBasketItems()) {
            sum += b.getAmount() * b.getId_item().getCost();
        }
        o.setSum(sum);
        return o;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> list() {
        List<Order> ret = (List<Order>) session().createCriteria(Order.class).list();
        for (Order o : ret) {
            int sum = 0;
            for (Basket b : o.getBasketItems()) {
                sum += b.getAmount() * b.getId_item().getCost();
            }
            int id = ret.indexOf(o);
            o.setSum(sum);
            ret.set(id, o);
        }
        return ret;
    }

    @Override
    public void cancel(int order_id) {
        Order o = get(order_id);
        o.setStatus(statusService.getCancelled());

    }

    @Override
    public void update(Order o) {
        session().update(o);
    }

    @Override
    public void changeStatus(int id_o, int status) {
        Order o = (Order) session().get(Order.class, id_o);
        o.setStatus(statusService.get(status));
        // session().save(o);

    }

}
