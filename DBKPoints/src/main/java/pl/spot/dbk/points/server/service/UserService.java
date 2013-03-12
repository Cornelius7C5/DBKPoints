package pl.spot.dbk.points.server.service;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.server.hib.User;

@Service
public interface UserService {
    public User get(Object id);
    public boolean update(User user);
}
