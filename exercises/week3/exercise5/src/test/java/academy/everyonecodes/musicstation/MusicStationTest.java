package academy.everyonecodes.musicstation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MusicStationTest {

    @Autowired
    MusicStation musicStation;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(new Song("Chan Chan", "Son")), "son"),
                Arguments.of(List.of(new Song("Windowscene", "Electronic"), new Song("The World Is Mine", "Electronic")), "electronic"),
                Arguments.of(List.of(), "pop")
        );
    }

    @Test
    void findAll() {
        List<Song> result = musicStation.findAll();

        List<Song> expected = List.of(new Song("Windowscene", "Electronic"),
                new Song("The World Is Mine", "Electronic"),
                new Song("Si Un Jour", "Psychedelic Rock"),
                new Song("Tomorrow Never Knows", "Psychedelic Rock"),
                new Song("Chan Chan", "Son"));
        assertEquals(result, expected);

    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Song> expected, String input) {
        List<Song> result = musicStation.findBy(input);
        assertEquals(expected, result);
    }
}