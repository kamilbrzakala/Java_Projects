import java.util.Scanner;

//Write a program that reads a string s and an int n, and then moves the first n characters of s to the end of the string. The program must output the changed string. If n is greater than the length of the string, it must output the string unchanged.
//
//        Note, the substring method can help you, but you may choose another way to solve the problem.
//
//
//        The single input line contains s and n separated by a space.
//
//
//        Sample Input:
//        Hello 3
//
//        Sample Output:
//        loHel


class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        char[] string = s.toCharArray();

        String newString = "";

        if (n > s.length()) {
            System.out.println(s);
        } else {
            for (int i = n; i < string.length ; i++) {
                newString += string[i];
            }
            for (int i = 0; i < n; i++) {
                newString += string[i];
            }
            System.out.println(newString);
        }
    }
}