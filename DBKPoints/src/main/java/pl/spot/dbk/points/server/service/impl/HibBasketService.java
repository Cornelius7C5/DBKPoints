package pl.spot.dbk.points.server.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.server.hib.Basket;
import pl.spot.dbk.points.server.service.BasketService;

@Transactional
public class HibBasketService implements BasketService {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(Basket b) {
        session().save(b);
    }

}
