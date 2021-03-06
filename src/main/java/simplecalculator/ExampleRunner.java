package simplecalculator;

import org.prifizapps.menuentities.input.AbstractInputRule;
import org.prifizapps.walkers.MenuWalkerInitiator;

import java.io.IOException;
import java.io.InputStream;

public class ExampleRunner {

    public void run() throws IOException {

        AbstractInputRule positive = new AbstractInputRule() {
            @Override
            public String getErrorMessage() {
                return "Value should be positive";
            }

            @Override
            public String getRuleDefName() {
                return "Positive";
            }

            @Override
            public boolean isPassed(String input) {
                return Integer.parseInt(input) > 0;
            }
        };

        InputStream inputStream = this.getClass().getResourceAsStream("calculatorMenu.yml");
        MenuWalkerInitiator.initMenu(inputStream)
                .registerAdapter(new AdditionAdapter())
                .registerAdapter(new DivisionAdapter())
                .withCustomInputProcessors(positive)
                .run();
    }
}
