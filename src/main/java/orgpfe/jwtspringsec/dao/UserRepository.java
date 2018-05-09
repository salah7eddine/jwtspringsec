package orgpfe.jwtspringsec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import orgpfe.jwtspringsec.entities.AppUser;


public interface UserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);
}
