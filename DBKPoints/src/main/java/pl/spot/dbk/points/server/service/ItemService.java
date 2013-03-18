package pl.spot.dbk.points.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.MetaObject;
import pl.spot.dbk.points.server.hib.Item;

@Service
public interface ItemService {
    public void create(Item item);

    public List<Item> list();

    public Item get(Object id);

    public ArrayList<MetaObject> listAsMetaObject() throws Exception;

    public void update(Item item);
}
