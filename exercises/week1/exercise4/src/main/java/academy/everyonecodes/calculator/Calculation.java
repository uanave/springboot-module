package academy.everyonecodes.calculator;

public abstract class Calculation {
    private String symbol;

    public Calculation(String symbol) {
        this.symbol = symbol;
    }

    public boolean matches(Expression expression) {
        return expression.getSymbol().equals(symbol);
    }

    public abstract double calculate(Expression expression);
}
