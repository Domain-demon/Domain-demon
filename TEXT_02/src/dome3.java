import java.util.Scanner;

public class dome3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个非负整数: ");
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("阶乘只定义于非负整数。");
        } else {
            long factorial = calculateFactorial(n);
            System.out.println(n + "! = " + factorial);
        }
        scanner.close();
    }

    public static long calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
}
