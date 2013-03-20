package pl.spot.dbk.points.server.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.server.hib.Status;
import pl.spot.dbk.points.server.service.StatusService;

@Transactional
public class HibStatusService implements StatusService {
    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Status getOrdered() {
        return (Status) session().get(Status.class, new Integer(2));
    }

    @Override
    public Status getPending() {
        return (Status) session().get(Status.class, new Integer(4));
    }

    @Override
    public Status getFinished() {
        return (Status) session().get(Status.class, new Integer(6));
    }

    @Override
    public Status getCancelled() {
        return (Status) session().get(Status.class, new Integer(8));
    }

}
