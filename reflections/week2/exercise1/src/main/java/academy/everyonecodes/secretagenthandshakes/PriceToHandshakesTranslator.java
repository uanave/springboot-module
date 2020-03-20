package academy.everyonecodes.secretagenthandshakes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("secretagent")
public class PriceToHandshakesTranslator {
    private int minPrice;
    private int maxPrice;
    private HandshakeNumberToMoveTranslator translator;

    public PriceToHandshakesTranslator(int minPrice, int maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    void setTranslator(HandshakeNumberToMoveTranslator translator) {
        this.translator = translator;
    }

    @Bean
    HandshakeNumberToMoveTranslator translator() {
        return translator;
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
        return List.of();
    }
}
