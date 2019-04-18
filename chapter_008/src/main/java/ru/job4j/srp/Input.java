package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

import java.util.List;
import java.util.Scanner;

public class Input {

    private final List<String> listOperations = new Calculator().getListOperations();

    private Scanner scanner = new Scanner(System.in);

    /**
     * Returns number entered by user.
     *
     * @return number.
     */
    public double getNumber() {
        System.out.println("Введите число:");
        while (!this.scanner.hasNextDouble()) {
            System.out.println("Неверное значение. Попробуйте еще раз.");
            this.scanner.nextLine();
        }
        return this.scanner.nextDouble();
    }

    /**
     * Returns operation entered by user.
     *
     * @return operation.
     */
    public String getOperation() {
        System.out.println("Введите операцию: " + this.listOperations.toString());
        String operation = this.scanner.next();
        return this.listOperations.contains(operation) ? operation : this.getOperation();
    }

    /**
     * Repeated operation selection and reuse of previous calculation.
     *
     * @return result.
     */
    public boolean isContinue() {
        System.out.println("Для продолжение введите 'y', для выхода: любую другую клавишу");
        return this.scanner.next().charAt(0) == 'y';
    }
}
