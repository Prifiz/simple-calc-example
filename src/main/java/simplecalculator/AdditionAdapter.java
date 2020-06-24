package simplecalculator;

import org.prifizapps.adapters.CommandLineAdapter;

// Adapter example
public class AdditionAdapter implements CommandLineAdapter {

    private String addFirst;
    private String addSecond;

    Calculator calculator = new CalculatorImpl();

    public String execute() {
        int first = Integer.parseInt(addFirst);
        int second = Integer.parseInt(addSecond);
        return String.valueOf(calculator.add(first, second));
    }
}
