package academy.everyonecodes.amazinghelloworld;

import org.springframework.stereotype.Service;

@Service
public class AmazingHelloWorld {
    private final Hello hello;
    private final World world;

    public AmazingHelloWorld(Hello hello, World world) {
        this.hello = hello;
        this.world = world;
    }

    public String get() {
        return hello.get() + " " + world.get();
    }
}
