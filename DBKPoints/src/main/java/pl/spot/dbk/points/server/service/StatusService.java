package pl.spot.dbk.points.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.server.hib.Status;

@Service
public interface StatusService {

    public Status getOrdered();

    public Status getPending();

    public Status getFinished();

    public Status getCancelled();

    public List<Status> list();

    public Status get(int status);

}
