import java.util.Scanner;


//Write a program that reads an array of ints and an integer number n.
//
//        The program must check how many times n occurs in the array.


class Main {
    public static void main(String[] args) {
        // put your code here
        final Scanner scanner = new Scanner(System.in);
        final int size = scanner.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int  countNum = 0;
        int n = scanner.nextInt();
        for (int j : array) {
            if (j == n ) {
                countNum++;
            }
        }
        System.out.println(countNum);

    }
}