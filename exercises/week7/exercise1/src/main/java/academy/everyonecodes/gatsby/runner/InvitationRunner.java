package academy.everyonecodes.gatsby.runner;

import academy.everyonecodes.gatsby.persistence.domain.Invitation;
import academy.everyonecodes.gatsby.persistence.repository.InvitationRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class InvitationRunner {

    @Bean
    ApplicationRunner runInvitations(InvitationRepository invitationRepository) {
        return args -> {
            boolean isOn = true;
            while (isOn) {
                runMenu();
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    System.out.println("--------------------------------------------");
                    System.out.println("The Great Gatsby Party Invitation Manager");
                    System.out.println("INVITE A PERSON");
                    System.out.println("> Write the person’s name:");
                    String name = scanner.nextLine();

                    Invitation invitation = new Invitation(name);
                    invitationRepository.save(invitation);
                    System.out.println("- " + name + " was added to the list.");
                }
                if (choice == 2) {
                    System.out.println("--------------------------------------------");
                    System.out.println("The Great Gatsby Party Invitation Manager");
                    System.out.println("SHOW ALL INVITATIONS\n");
                    if (invitationRepository.findAll().isEmpty()) {
                        System.out.println("No invitations yet");
                    } else {
                        invitationRepository.findAll().forEach(invitation -> System.out.println(invitation.getName()));
                    }

                    System.out.println("> Press any key to continue.");
                    String answer = scanner.nextLine();

                }
                if (choice == 3) {
                    System.out.println("--------------------------------------------");
                    System.out.println("The Great Gatsby Party Invitation Manager\n");
                    System.out.println("CONCLUDE THE CURRENT PARTY\n");
                    System.out.println("> Do you want to conclude the party? (y, N)");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("Y")) {
                        System.out.println("- The current party was concluded.");
                        invitationRepository.deleteAll();
                    } else {
                        System.out.println("- The current party is still ongoing.");
                    }
                }
                if (choice == 4) {
                    System.exit(0);
                }
            }

        };
    }

    public void runMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("The Great Gatsby Party Invitation Manager");
        System.out.println("MENU\n");
        System.out.println("1.- Invite a person.");
        System.out.println("2.- Show all invitations.");
        System.out.println("3.- Conclude the current party.");
        System.out.println("4.- Exit.\n");
        System.out.println("> Choose one option (1-4):");
    }
}
