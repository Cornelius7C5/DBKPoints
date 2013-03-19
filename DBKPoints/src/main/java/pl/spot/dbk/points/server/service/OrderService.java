package pl.spot.dbk.points.server.service;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.server.hib.Order;

@Service
public interface OrderService {

    public void create(Order o);

}
