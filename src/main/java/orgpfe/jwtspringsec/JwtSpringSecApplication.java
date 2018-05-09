package orgpfe.jwtspringsec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import orgpfe.jwtspringsec.dao.TaskRepository;
import orgpfe.jwtspringsec.entities.AppRole;
import orgpfe.jwtspringsec.entities.AppUser;
import orgpfe.jwtspringsec.entities.Task;
import orgpfe.jwtspringsec.service.AccountService;

import java.util.stream.Stream;

@SpringBootApplication
public class JwtSpringSecApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository  taskRepository;
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE(){return new BCryptPasswordEncoder();}

	@Override
	public void run(String... args) throws Exception {
		accountService.saveUser(new AppUser("admin","123"));
		accountService.saveUser(new AppUser("user","123"));
		accountService.saveRole(new AppRole("ADMIN"));
		accountService.saveRole(new AppRole("USER"));
		accountService.addRoleToUse("admin","ADMIN");
		accountService.addRoleToUse("admin","USER");
		accountService.addRoleToUse("user","USER");

		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save(new Task(null,t));
		});

		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});
	}
}
