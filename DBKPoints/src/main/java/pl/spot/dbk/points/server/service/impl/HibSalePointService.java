package pl.spot.dbk.points.server.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.server.hib.SalePoint;
import pl.spot.dbk.points.server.service.SalePointService;

@Transactional
public class HibSalePointService extends AbstractHibService implements SalePointService {

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
    public void create(SalePoint sp) {
        session().save(sp);

    }

}
