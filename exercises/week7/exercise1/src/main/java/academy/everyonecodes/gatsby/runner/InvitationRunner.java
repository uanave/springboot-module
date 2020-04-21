package academy.everyonecodes.gatsby.runner;

import academy.everyonecodes.gatsby.logic.InvitationService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InvitationRunner {


    @Bean
    ApplicationRunner runInvitations(InvitationService invitationService) {
        return args -> {
            invitationService.invite();
        };
    }
}
