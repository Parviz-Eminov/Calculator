package Calculator;

import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    BinaryOperator<Integer> devide = (x, y) -> {
        if (y == 0) {
            System.out.println("Ошибка: деление на ноль!");
            return 0;
        } else {
            return x / y;
        }
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}

class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);    // 3
        int b = calc.minus.apply(1, 1);   // 0

        // Если не обработать деление на ноль, возникнет ArithmeticException
        // int c = calc.devide.apply(a, b); // Ошибка деления на 0

        /*
        * BinaryOperator<Integer> devide = (x, y) -> {
        * if (y == 0) {
        *     throw new ArithmeticException("Деление на ноль недопустимо!");
        *  }
        *   return x / y;
        *  };
        */
        // Но тогда в main() нужно будет использовать try-catch.


        int c = calc.devide.apply(a, b);  // Обработка предусмотрена внутри метода

        calc.println.accept(c);   // Вывод результата
    }
}



