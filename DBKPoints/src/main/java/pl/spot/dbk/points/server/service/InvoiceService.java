package pl.spot.dbk.points.server.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.MetaObject;
import pl.spot.dbk.points.server.hib.Invoice;

@Service
public interface InvoiceService {
    public int getPointsByUser(Object id);

    public void update(Invoice invoice);

    public Invoice create(Invoice invoice);

    public Invoice get(int id);

    public ArrayList<MetaObject> listAsMetaObject() throws Exception;
}
