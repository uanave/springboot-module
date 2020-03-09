package academy.everyonecodes.helloworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldTest {

    @Autowired
    HelloWorld helloWorld;

    @Test
    void get() {
        String result = helloWorld.get();
        String expected = "Hello World";
        Assertions.assertEquals(expected, result);
    }
}