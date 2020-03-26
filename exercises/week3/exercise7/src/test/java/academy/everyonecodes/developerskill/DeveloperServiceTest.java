package academy.everyonecodes.developerskill;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DeveloperServiceTest {

    @Autowired
    DeveloperService developerService;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(
                        new Developer("Seth", Set.of("Javascript", "CSS", "HTML"))), "Javascript CSS HTML"),
                Arguments.of(List.of(
                        new Developer("Seth", Set.of("Javascript", "CSS", "HTML")),
                        new Developer("Sonia", Set.of("Python", "HTML", "CSS"))), "CSS HTML"),
                Arguments.of(List.of(), "Java C++"),
                Arguments.of(List.of(
                        new Developer("Seth", Set.of("Javascript", "CSS", "HTML")),
                        new Developer("Tom", Set.of("Kotlin", "Python", "Javascript"))), "Javascript"),
                Arguments.of(List.of(
                        new Developer("Sarah", Set.of("Java", "Spring-Boot"))), "Spring-Boot Java")
        );
    }

    @Test
    void findAll() {
        List<Developer> result = developerService.findAll();

        List<Developer> expected = List.of(
                new Developer("Seth", Set.of("Javascript", "CSS", "HTML")),
                new Developer("Sarah", Set.of("Java", "Spring-Boot")),
                new Developer("Sonia", Set.of("Python", "HTML", "CSS")),
                new Developer("Tom", Set.of("Kotlin", "Python", "Javascript"))
        );

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Developer> expected, String input) {
        List<Developer> result = developerService.findBy(input);
        assertEquals(expected, result);
    }
}