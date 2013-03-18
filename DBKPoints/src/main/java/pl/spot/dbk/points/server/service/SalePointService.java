package pl.spot.dbk.points.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.MetaObject;
import pl.spot.dbk.points.server.hib.SalePoint;

@Service
public interface SalePointService {
    public List<SalePoint> list();

    public SalePoint get(Object id);

    public void create(SalePoint sp);

    public void save(SalePoint workSalePoint);

    public ArrayList<MetaObject> listAsMetaObject();

    public void update(SalePoint sp);

}
