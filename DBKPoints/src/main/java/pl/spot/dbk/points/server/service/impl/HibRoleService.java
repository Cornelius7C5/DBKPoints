package pl.spot.dbk.points.server.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pl.spot.dbk.points.server.hib.Role;
import pl.spot.dbk.points.server.service.RoleService;

@Transactional
public class HibRoleService extends AbstractHibService implements RoleService {

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> list() {
        return session().createCriteria(Role.class).list();
    }

    @Override
    public Role getRole(String role_id) {
        return (Role) session().get(Role.class, new Integer(role_id));
    }

}
