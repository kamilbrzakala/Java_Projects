import java.util.Scanner;

//Write a program that reads a string and checks whether it is a palindrome, i.e. it reads the same both left-to-right and right-to-left.
//
//        The program must output “yes” if the string is a palindrome and “no” otherwise.
//
//
//        Sample Input:
//        kayak
//        Sample Output:
//        yes


class Palindrome {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char[] ch = string.toCharArray();
        String reverse = "";
        for (int i=string.length() - 1; i >=0 ; i--){
            reverse += ch[i];
        }
        if (string.equals(reverse) ) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
