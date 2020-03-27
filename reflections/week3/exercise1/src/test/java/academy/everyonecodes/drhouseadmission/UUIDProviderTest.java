package academy.everyonecodes.drhouseadmission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UUIDProviderTest {
    UUIDProvider uuidProvider = new UUIDProvider();

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(Optional.of("3bc716e1-9c68-4c42-bc89-62b4e9c67f69"), "Mary")
        );
    }

    @Test
    void provideUUID() {
        uuidProvider.provideUUID(new Patient("Mary", "3bc716e1-9c68-4c42-bc89-62b4e9c67f69", List.of("headache")));

        HashMap<String, String> result = uuidProvider.getCacheSnapshot();

        HashMap<String, String> expected = new HashMap<>();
        expected.put("Mary", "3bc716e1-9c68-4c42-bc89-62b4e9c67f69");

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void findUUID(Optional<String> expected, String input) {
        uuidProvider.provideUUID(new Patient("Mary", "3bc716e1-9c68-4c42-bc89-62b4e9c67f69", List.of("headache")));

        Optional<String> result = uuidProvider.findUUID(input);
        Assertions.assertEquals(expected, result);
    }
}