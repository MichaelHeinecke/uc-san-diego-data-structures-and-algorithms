import java.util.Scanner;

public class SumOfTwoDigits {

    static final Scanner sc = new Scanner(System.in);

    public static int add(int summandOne, int summandTwo) {
        return summandOne + summandTwo;
    }

    public static void main(String[] args) {
        int inputOne = sc.nextInt();
        int inputTwo = sc.nextInt();

        System.out.println(add(inputOne, inputTwo));

        sc.close();
    }

}
