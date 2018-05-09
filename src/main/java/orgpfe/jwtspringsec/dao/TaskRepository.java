package orgpfe.jwtspringsec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import orgpfe.jwtspringsec.entities.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
