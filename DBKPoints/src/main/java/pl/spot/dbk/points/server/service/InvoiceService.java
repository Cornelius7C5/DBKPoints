package pl.spot.dbk.points.server.service;

import org.springframework.stereotype.Service;

@Service
public interface InvoiceService {
    public int getPointsByUser(Object id);
}
