package pl.spot.dbk.points.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.server.hib.Order;

@Service
public interface OrderService {

    public Order create(Order o);

    public Order get(int id);

    public void update(Order o);

    public List<Order> list();

    public void cancel(int order_id);

    public void changeStatus(int id_o, int status);

}
