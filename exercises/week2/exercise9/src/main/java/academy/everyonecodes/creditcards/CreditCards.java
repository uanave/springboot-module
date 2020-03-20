package academy.everyonecodes.creditcards;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreditCards {
    private final Set<Issuer> issuers;
    private final Luhn luhn;

    public CreditCards(Set<Issuer> issuers, Luhn luhn) {
        this.issuers = issuers;
        this.luhn = luhn;
    }

    public String inspect(String creditCard) {
        if (luhn.isValid(creditCard)) {
            return issuers.stream()
                    .filter(issuer -> issuer.issues(creditCard))
                    .map(Issuer::getName)
                    .findFirst()
                    .orElse("Not Supported");
        }
        return "Invalid";
    }
}
