package pl.spot.dbk.points.server.service;

import java.util.List;

import pl.spot.dbk.points.server.hib.SalePoint;


public interface SalePointService{
    List<SalePoint> list();
    SalePoint get(Object id);
    void create(SalePoint sp);    
}
