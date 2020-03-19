package academy.everyonecodes.creditcards;

import java.util.Set;

public class Issuer {
    private String name;
    private Set<String> startsWith;
    private Set<Integer> lengths;

    public Issuer() {
    }

    public Issuer(String name, Set<String> startsWith, Set<Integer> lengths) {
        this.name = name;
        this.startsWith = startsWith;
        this.lengths = lengths;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    void setStartsWith(Set<String> startsWith) {
        this.startsWith = startsWith;
    }

    void setLengths(Set<Integer> lengths) {
        this.lengths = lengths;
    }

    public boolean issues(String creditCard) {
        boolean matchesStart = startsWith.stream()
                .anyMatch(creditCard::startsWith);
        boolean hasLength = lengths.stream()
                .anyMatch(e -> creditCard.length() == e);
        return (matchesStart && hasLength);
    }
}
