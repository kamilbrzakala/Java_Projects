import java.util.Scanner;

//Output the matrix of size n×n, filled by the integers from 1 to n2 in a spiral,
//        coming from the top left corner and twisted clockwise, as shown in the example (here n=5).
//
//        Sample Input:
//        5
//        Sample Output:
//        1 2 3 4 5
//        16 17 18 19 6
//        15 24 25 20 7
//        14 23 22 21 8
//        13 12 11 10 9


class SpiralArray {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];

        int xStart = 0;
        int xLast = size - 1;
        int yStart = 0;
        int yLast = size - 1;

        int element = 1;
        while (element <= size * size) {
            for (int i = xStart; i <= xLast; ++i) {
                matrix[yStart][i] = element++;
            }
            ++yStart;
            for (int i = yStart; i <= yLast; ++i) {
                matrix[i][xLast] = element++;
            }
            --xLast;
            for (int i = xLast; i >= xStart; --i) {
                matrix[yLast][i] = element++;
            }
            --yLast;
            for (int i = yLast; i >= yStart; --i) {
                matrix[i][xStart] = element++;
            }
            ++xStart;
        }

        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j <     size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
