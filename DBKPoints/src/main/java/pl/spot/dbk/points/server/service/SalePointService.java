package pl.spot.dbk.points.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.server.hib.SalePoint;

@Service
public interface SalePointService {
    List<SalePoint> list();

    SalePoint get(Object id);

    void create(SalePoint sp);

    void save(SalePoint workSalePoint);

}
