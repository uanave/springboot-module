package academy.everyoncodes.amazinggoodbyeworld;

public class AmazingGoodbyeWorld {
    private final Goodbye goodbye;
    private final World world;

    public AmazingGoodbyeWorld(Goodbye goodbye, World world) {
        this.goodbye = goodbye;
        this.world = world;
    }

    public Goodbye getGoodbye() {
        return goodbye;
    }

    public World getWorld() {
        return world;
    }

    public String get() {
        return goodbye.get() + " " + world.get();
    }
}
