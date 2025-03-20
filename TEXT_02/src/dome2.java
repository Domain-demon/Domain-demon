import java.util.Scanner;

public class dome2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        System.out.print("请输入第一个整数: ");
        a = scanner.nextInt();
        System.out.print("请输入第二个整数: ");
        b = scanner.nextInt();

        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        double quotient;
        if (b != 0) {
            quotient = (double) a / b;
        } else {
            quotient = Double.NaN;
        }

        System.out.println("和: " + sum);
        System.out.println("差: " + difference);
        System.out.println("积: " + product);
        if (b != 0) {
            System.out.println("商: " + quotient);
        } else {
            System.out.println("商: 未定义 (除数不能为零)");
        }

        scanner.close();
    }
}
