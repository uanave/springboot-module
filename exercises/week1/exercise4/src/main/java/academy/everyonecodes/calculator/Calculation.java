package academy.everyonecodes.calculator;

public abstract  class Calculation {
    private String symbol;

    public Calculation(String symbol) {
        this.symbol = symbol;
    }

    public boolean matches(Expression expression) {
        return expression.getSymbol().equals(symbol);
    }

    public double calculate(Expression expression) {
        double number1 = expression.getTerm1();
        double number2 = expression.getTerm2();
        String symbol = expression.getSymbol();
        return number1  + Integer.parseInt(symbol) + number2;
    }
}
