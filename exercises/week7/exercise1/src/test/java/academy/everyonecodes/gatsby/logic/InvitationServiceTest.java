package academy.everyonecodes.gatsby.logic;

import academy.everyonecodes.gatsby.persistence.domain.Invitation;
import academy.everyonecodes.gatsby.persistence.repository.InvitationRepository;
import academy.everyonecodes.gatsby.runner.InvitationRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class InvitationServiceTest {

    @Autowired
    InvitationService invitationService;

    @MockBean
    InvitationRepository invitationRepository;

    @MockBean
    InvitationRunner invitationRunner;

    @Test
    void invitePerson() {
//        invitationService.invite();
////
//        Invitation invitation = new Invitation("Tom");
//        verify(invitationService).invite();
//        verify(invitationRepository).save(invitation);
//        verify(invitationRepository).delete(invitation);


    }
}