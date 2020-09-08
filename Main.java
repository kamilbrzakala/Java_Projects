import java.util.Scanner;

//Given a two-dimensional array (matrix) and the two numbers: i and j. Swap the columns with indexes i and j within the matrix.
//
//        Input contains matrix dimensions n and m, not exceeding 100, then the elements of the matrix, then the indexes i and j.
//
//
//        Sample Input:
//        3 4
//        11 12 13 14
//        21 22 23 24
//        31 32 33 34
//        0 1
//        Sample Output:
//        12 11 13 14
//        22 21 23 24
//        32 31 33 34

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size1 = scanner.nextInt();
        int size2 = scanner.nextInt();

        int[][] matrix = new int[size1][size2];

        int tempValue = 11;

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                matrix[i][j] = scanner.nextInt();
                tempValue++;
            }
        }
        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();

        for (int i = 0; i < matrix.length; i++) {
            final int tmp = matrix[i][index1];
            matrix[i][index1] = matrix[i][index2];
            matrix[i][index2] = tmp;
        }
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}