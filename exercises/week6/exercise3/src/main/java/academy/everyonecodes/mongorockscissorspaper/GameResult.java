package academy.everyonecodes.mongorockscissorspaper;

public class GameResult {
    private String id;
    private String result;

    public GameResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "id='" + id + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
