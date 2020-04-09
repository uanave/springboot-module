package academy.everyonecodes.basket.domain;

import java.util.List;

public class Basket {
    private final List<Summary> summaries;

    public Basket(List<Summary> summaryList) {
        this.summaries = summaryList;
    }

    public void add(Summary summary) {
        summaries.add(summary);
    }

    public List<Summary> findAll() {
        return summaries;
    }
}
