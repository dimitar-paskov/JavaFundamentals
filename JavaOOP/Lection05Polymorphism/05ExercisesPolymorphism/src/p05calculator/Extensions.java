package p05calculator;

public class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        InputInterpreter inputInterpreter = new InputInterpreter(engine);

        return inputInterpreter;

    }
}
