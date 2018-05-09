package orgpfe.jwtspringsec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

//@Data @NoArgsConstructor @AllArgsConstructor
public class AppRole {
    @Id @GeneratedValue
    private Long id;
    private String roleName;

    public AppRole() {
    }

    public AppRole(String roleName) {

        this.roleName = roleName;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
