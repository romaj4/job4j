package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class InteractCalc {

    private final List<String> oneOperandOperations = new Calculator().getOneOperandOperations();

    private final Input input = new Input();

    private final Calculator calculator = new Calculator();

    /**
     * Interactive calculator start.
     */
    private void start() {
        double result = this.input.getNumber();
        do {
            String operation = this.input.getOperation();
            if (this.oneOperandOperations.contains(operation)) {
                result = this.calculation(result, operation, 0);
            } else {
                result = this.calculation(result, operation, this.input.getNumber());
            }
            System.out.println("Результат:  " + result);
        } while (this.input.isContinue());
    }

    /**
     * Arithmetic calculations.
     *
     * @param first     number.
     * @param operation operation.
     * @param second    number.
     * @return result.
     */
    public double calculation(double first, String operation, double second) {
        Map<String, Double> operations = new HashMap<>();
        operations.put("+", this.calculator.add(first, second));
        operations.put("-", this.calculator.subtract(first, second));
        operations.put("/", this.calculator.div(first, second));
        operations.put("*", this.calculator.multiply(first, second));
        operations.put("sin", this.calculator.sin(first));
        operations.put("cos", this.calculator.cos(first));
        operations.put("tan", this.calculator.tan(first));
        return operations.get(operation);
    }
}
