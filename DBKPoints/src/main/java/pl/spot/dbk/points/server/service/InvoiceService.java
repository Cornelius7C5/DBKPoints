package pl.spot.dbk.points.server.service;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.server.hib.Invoice;

@Service
public interface InvoiceService {
    public int getPointsByUser(Object id);

    public void update(Invoice invoice);
}
