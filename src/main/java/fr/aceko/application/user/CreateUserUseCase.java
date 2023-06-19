package fr.aceko.application.user;

import fr.aceko.ui.rest.CreateUserRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    private final UserDetailsService userDetailsService;

    public CreateUserUseCase(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public boolean execute(CreateUserRequest request){
        InMemoryUserDetailsManager userDetailsManager = (InMemoryUserDetailsManager) this.userDetailsService;
        userDetailsManager.createUser(User.withDefaultPasswordEncoder().username(request.username).password(request.password).roles("ADMIN").build());
        return true;
    }
}
