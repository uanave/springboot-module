package academy.everyonecodes.amazinghelloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HelloTest {

    @Autowired
    Hello hello;

    @Test
    void get() {
        String result = hello.get();

        String expected = "Hello";
        assertEquals(expected, result);
    }
}