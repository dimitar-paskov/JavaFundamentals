package p05calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class msOperation implements Operation {
    private List<Integer> operands;
    private int result;
    private ArrayDeque<Integer> stack;

    public msOperation(ArrayDeque<Integer> stack){

        this.operands = new ArrayList<>();
        this.stack = stack;
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);

        if (this.isCompleted()) {
            this.result = this.operands.get(0);
            this.stack.push(this.result);
        }
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 1;
    }

    @Override
    public int getResult() {
        return this.result;
    }
}
