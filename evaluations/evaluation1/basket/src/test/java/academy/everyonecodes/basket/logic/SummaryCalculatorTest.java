package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.communication.client.UsersClient;
import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class SummaryCalculatorTest {

    @Autowired
    SummaryCalculator summaryCalculator;

    @MockBean
    UsersClient usersClient;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new Summary("unknown@test.com", "test", 1.0, 2, 1 + 2),
                        Optional.empty(),
                        new ItemSelection("unknown@test.com", "test", 1.0)
                ),
                Arguments.of(
                        new Summary("standard@test.com", "test", 1.0, 2, 1 + 2),
                        Optional.of(new User("standard@test.com", "standard")),
                        new ItemSelection("standard@test.com", "test", 1.0)
                ),
                Arguments.of(
                        new Summary("premium@test.com", "test", 1.0, 0, 1),
                        Optional.of(new User("premium@test.com", "premium")),
                        new ItemSelection("premium@test.com", "test", 1.0)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(Summary expected, Optional<User> oUser, ItemSelection itemSelection) {
        when(usersClient.get(itemSelection.getUserEmail()))
                .thenReturn(oUser);

        Summary result = summaryCalculator.calculate(itemSelection);

        assertEquals(expected, result);
    }

}
