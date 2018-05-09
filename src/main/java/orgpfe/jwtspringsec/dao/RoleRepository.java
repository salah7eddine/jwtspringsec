package orgpfe.jwtspringsec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import orgpfe.jwtspringsec.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole,Long> {
    public AppRole findByRoleName(String roleName);
}
