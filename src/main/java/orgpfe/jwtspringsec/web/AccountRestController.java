package orgpfe.jwtspringsec.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import orgpfe.jwtspringsec.entities.AppUser;
import orgpfe.jwtspringsec.service.AccountService;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterForm userForm){
       if(!userForm.getPassword().equals(userForm.getRepassword()))
           throw new RuntimeException("You must confirm your password");

       AppUser user=accountService.findUserByUserName(userForm.getUsername());
       if(user !=null) throw new RuntimeException("This user already exists");
        AppUser appUser=new AppUser();
        appUser.setUsername(userForm.getUsername());
        appUser.setPassword(userForm.getPassword());
        accountService.saveUser(appUser);
        accountService.addRoleToUse(userForm.getUsername(),"USER");
        return appUser;
    }
}
