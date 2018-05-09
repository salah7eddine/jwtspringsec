package orgpfe.jwtspringsec.service;

import orgpfe.jwtspringsec.entities.AppRole;
import orgpfe.jwtspringsec.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUse(String username,String roleName);
    public AppUser findUserByUserName(String username);

}
