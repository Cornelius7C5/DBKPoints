package pl.spot.dbk.points.server.service;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.server.hib.Basket;

@Service
public interface BasketService {

    public Basket create(Basket b);

    public Basket get(int id);

}
