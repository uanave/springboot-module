package academy.everyonecodes.secretagenthandshakes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PriceToHandshakesTranslator {
    private int minPrice;
    private int maxPrice;
    private HandshakeNumberToMoveTranslator translator;

    public PriceToHandshakesTranslator(@Value("${secretagent.minPrice}") int minPrice,
                                       @Value("${secretagent.maxPrice}") int maxPrice,
                                       HandshakeNumberToMoveTranslator translator) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.translator = translator;
    }

    public List<String> translate(int number) {
        if (number < minPrice || number > maxPrice) {
            return new ArrayList<>();
        }
        return translate(String.valueOf(number));
    }

    private List<String> translate(String number) {
        String[] digits = number.split("");
        return Stream.of(digits)
                .map(Integer::valueOf)
                .map(translator::translate)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }
}
