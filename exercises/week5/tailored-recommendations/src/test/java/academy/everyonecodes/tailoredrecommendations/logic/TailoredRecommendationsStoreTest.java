package academy.everyonecodes.tailoredrecommendations.logic;

import academy.everyonecodes.tailoredrecommendations.domain.Movie;
import academy.everyonecodes.tailoredrecommendations.domain.TailoredRecommendation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static org.springframework.test.annotation.DirtiesContext.MethodMode.AFTER_METHOD;

@SpringBootTest(webEnvironment = NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TailoredRecommendationsStoreTest {

    @Autowired
    TailoredRecommendationsStore tailoredRecommendationsStore;

    static Stream<Arguments> parameters() {
        return Stream.of(
                of(List.of(new Movie("test1", "test1")), "1"),
                of(List.of(new Movie("test2", "test2")), "2"),
                of(List.of(), "3")
        );
    }

    @DirtiesContext(methodMode = AFTER_METHOD)
    @Test
    @Order(1)
    void postOne() {
        TailoredRecommendation tailoredRecommendation = new TailoredRecommendation("3", new Movie("test3", "test3"));
        tailoredRecommendationsStore.postOne(tailoredRecommendation);
        List<TailoredRecommendation> result = tailoredRecommendationsStore.getAll();
        assertEquals(3, result.size());
    }

    @ParameterizedTest
    @MethodSource("parameters")
    @Order(3)
    void getMoviesPerId(List<Movie> expected, String input) {
        List<Movie> result = tailoredRecommendationsStore.getMoviesById(input);
        assertEquals(expected, result);
    }

    @Test
    @Order(2)
    void get() {
        List<TailoredRecommendation> result = tailoredRecommendationsStore.getAll();
        List<TailoredRecommendation> expected = List.of(
                new TailoredRecommendation("1", new Movie("test1", "test1")),
                new TailoredRecommendation("2", new Movie("test2", "test2"))
        );
        assertEquals(expected, result);
    }


}