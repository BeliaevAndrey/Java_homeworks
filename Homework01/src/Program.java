import java.util.Scanner;
public class Program {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Калькулятор.");
        boolean flag = true;
        while (flag) {
            System.out.print("Введите первое число: ");
            double a = get_num();
            System.out.print("Введите второе число: ");
            double b = get_num();
            System.out.print("Введите желаемую операцию: ");
            String op = scn.next();
            double res = calculate(a, b, op);
            if (res - (int)res == 0) System.out.printf("Результат: %d\n", (int)res);
            else if (res > 1e19 || res < 1e-6) System.out.printf("Результат: %.3e\n", res);
            else System.out.printf("Результат: %f\n", res);
            flag = get_flag();
        }
        scn.close();
    }
    static double calculate(double a, double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "^":
                return Math.pow(a, b);
            default:
                System.out.println("Неизвестная опреация.");
                return 0;
        }
    }
    static double get_num(){
        double out = 0;
        if (scn.hasNextDouble()) {
            out = scn.nextDouble();
        } else {
            System.out.println("Неверный ввод. Число приравнено 0");
        }
        return out;
    }
    static boolean get_flag(){
        System.out.print("Хотите продолжить? (да|yes / нет|no): ");
        while (true) {
            String ans = scn.next().toLowerCase();
            if (ans.equals("нет") || ans.equals("no")) {
                System.out.println("Всего хорошего!");
                return false;
            } else if (ans.equals("да") || ans.equals("yes")) {
                return true;
            } else {
                System.out.print("Неразборчиво... попробуйте еще раз: ");
            }
        }
    }
}
