package academy.everyonecodes.thefinalcountdown;

public class Countdown {
    private String id;
    private int count;

    public Countdown(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Countdown{" +
                "id='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}
