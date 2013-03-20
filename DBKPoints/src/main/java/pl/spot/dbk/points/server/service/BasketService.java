package pl.spot.dbk.points.server.service;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.server.hib.Basket;

@Service
public interface BasketService {

    public void create(Basket b);

}
