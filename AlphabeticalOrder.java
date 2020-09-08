import java.util.Scanner;

//Write a program that reads an array of lowercase strings
// and checks whether the array is in alphabetical order or not.




class AlphabeticalOrder {
    public static void main(String[] args) {
        // put your code here

        final Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        boolean isTrue = true;

        for (int i = 0; i < array.length; i++) {
            String first = array[i];
            String second = "";
            try {
                second = array[i + 1];
            } catch (Exception ex) {
                second = array[i];
                break;
            }

//            System.out.println("first: " + first);
//            System.out.println("second: " + second);
//            System.out.println("first to second: " + first + " second: "+ second + " result: " + first.compareTo(second));

            if (first.compareTo(second) <= 0) {
                isTrue = true;

            } else {

                isTrue = false;
                break;

            }
        }
        System.out.println(isTrue);
    }
}
