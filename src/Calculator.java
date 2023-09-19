import java.util.Scanner;

/**
 * @author Aleksei Timoshenko
 */

public class Calculator {
    public static void main(String[] args) {

        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения" +
                "\nи деления с двумя числами: a+b, a-b, a*b, a/b." +
                "\nКалькулятор умеет работать одновременно только с арабскими (1,2,3,4,5…)," +
                "\nцелыми числами от 1 до 10." +
                "\nРезультатом операции деления является целое число, остаток отбрасывается." +
                "\nРезультатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) {
        char operation = 0;
        char[] symbol = new char[10];
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            symbol[i] = input.charAt(i);
            if (symbol[i] == '+' | symbol[i] == '-' | symbol[i] == '*' | symbol[i] == '/') {
                count++;
                if (count > 1) {
                    System.out.println("Ошибка! попробуйте еще раз.");
                    System.exit(0);
                }
            }
            if (symbol[i] == '.' | symbol[i] == ',') {
                System.out.println("Калькулятор умеет работать только с целыми цифрами от 1 до 10 одновременно! Попробуйте снова.");
                System.exit(0);
            }
            if (symbol[i] == '+') {
                operation = '+';
            }
            if (symbol[i] == '-') {
                operation = '-';
            }
            if (symbol[i] == '*') {
                operation = '*';
            }
            if (symbol[i] == '/') {
                operation = '/';
            }
        }

        int number1;
        int number2;
        int result;
        try {
            String variationString = String.valueOf(symbol);
            String[] splitOption = variationString.split("[+-/*]");
            String var0 = splitOption[0];
            String var1 = splitOption[1];
            String var3 = var1.trim();
            number1 = Integer.parseInt(var0);
            number2 = Integer.parseInt(var3);
            if (number1 > 10 | number2 > 10 | number1 < 0 | number2 < 0) {
                System.out.println("Калькулятор умеет работать только с целыми цифрами от 1 до 10 одновременно! Попробуйте снова.");
                System.exit(0);
            }
            result = calculate(number1, number2, operation);
            System.out.println("Результат выражения: " + number1 + operation + number2 + "=" + result);
        } catch (Exception e) {
            System.out.println(e.getMessage() + ": Ошибка,попробуйте еще раз");
        }
        return "";
    }


    static int calculate(int number1, int number2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("Неверный знак для операции");
        }
        return result;
    }
}