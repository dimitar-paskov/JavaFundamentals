package p05calculator;

import java.util.ArrayDeque;

public class InputInterpreter {
    private CalculationEngine engine;
    private ArrayDeque<Integer> stack;

    public InputInterpreter(CalculationEngine engine){

        this.engine = engine;
        this.stack = new ArrayDeque<>();
    }

    public boolean interpret(String input) {
        if (input.equals("mr")){
            input = this.stack.pop().toString();
        }

        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }
        if (operation.equals("/")) {
            return new DivisionOperation();
        }
        if (operation.equals("ms")) {
            return new msOperation(this.stack);
        }

        return null;
    }
}
