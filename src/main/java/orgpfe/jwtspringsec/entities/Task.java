package orgpfe.jwtspringsec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Data @AllArgsConstructor @NoArgsConstructor
public class Task {
    @Id @GeneratedValue
    private Long id;
    private String taskName;

    public Task() {
    }

    public Task(Long id, String taskName) {

        this.id = id;
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
