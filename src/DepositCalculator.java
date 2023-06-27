import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateIncome();
    }

    double calculateComplexPercent(double amount, int depositPeriod) {
        double payment = amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriod);
        return roundValue(payment);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return roundValue(amount + amount * 0.06 * depositPeriod);
    }

    double roundValue(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    void calculateIncome() {
        Scanner scanner = new Scanner(System.in);
        double result = 0;

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        if (action == 1) {
            result = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }
}
