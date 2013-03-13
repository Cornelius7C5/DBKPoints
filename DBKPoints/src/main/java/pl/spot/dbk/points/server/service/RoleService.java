package pl.spot.dbk.points.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.spot.dbk.points.server.hib.Role;

@Service
public interface RoleService {
    List<Role> list();

    Role getRole(String role_id);
}
