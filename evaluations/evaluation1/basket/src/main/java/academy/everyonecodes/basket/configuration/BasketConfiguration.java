package academy.everyonecodes.basket.configuration;

import academy.everyonecodes.basket.domain.Basket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class BasketConfiguration {

    @Bean
    Basket basket() {
        return new Basket(new ArrayList<>());
    }
}
