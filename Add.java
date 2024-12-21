import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int num1 = scanner.nextInt();
        System.out.println("Enter the second number:");
        int num2 = scanner.nextInt();
        int sum = addNumbers(num1, num2);
        System.out.println("The sum is: " + sum);
    }

    public static int addNumbers(int num1, int num2) {
        return num1 + num2;
    }
}