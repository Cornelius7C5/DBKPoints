package pl.spot.dbk.points.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.MetaObject;
import pl.spot.dbk.points.server.hib.SalePoint;
import pl.spot.dbk.points.server.service.SalePointService;

@Transactional
public class HibSalePointService implements SalePointService {
    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SalePoint> list() {
        return session().createCriteria(SalePoint.class).list();
    }

    @Override
    public SalePoint get(Object id) {
        return (SalePoint) session().get(SalePoint.class, new Integer(id.toString()));
    }

    @Override
    public SalePoint create(SalePoint sp) {
        int id = (Integer) session().save(sp);
        return (SalePoint) get(id);
    }

    @Override
    public void save(SalePoint sp) {
        session().save(sp);
    }

    @Override
    public ArrayList<MetaObject> listAsMetaObject() {
        ArrayList<MetaObject> ret = new ArrayList<MetaObject>();

        for (SalePoint sp : list()) {
            ret.add(sp.getMetaObject());
        }

        return ret;
    }

    @Override
    public void update(SalePoint sp) {
        session().update(sp);
    }

}
