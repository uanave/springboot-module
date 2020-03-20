package academy.everyonecodes.secretagenthandshakes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<String> translate(int price) {
        if (price >= minPrice && price <= maxPrice) {
            String priceToString = String.valueOf(price);
            List<String> digits = List.of(priceToString.split(""));
            return digits.stream()
                    .map(e -> translator.translate(Integer.parseInt(e)))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
