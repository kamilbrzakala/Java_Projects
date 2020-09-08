package tictactoe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    private static Collection<String> getConsecutiveOccurrenceOfChar(String string) {

        Collection<String> charCounts = new ArrayList<>();
        char current = string.charAt(0);
        int count = 1;

        for (int i = 1; i < string.length(); i++) {
            char c = string.charAt(i);

            if (current == c) {
                count++;
            } else {
                charCounts.add(current + " : " + count);
                count = 1;
                current = c;
            }
        }
        charCounts.add(current + " : " + count);

        return charCounts;
    }

    private static void fillInitialMatrix (String s) {
        for (int i = 0; i < 3; i++) {
            matrix[i][0] = "|";
            matrix[i][4] = "|";
            for (int j = 1; j < 4; j++) {
                matrix[i][j] = String.valueOf(s.charAt(x));
                x++;
            }
        }
    }
    private static void printMatrix (String[][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j].contains("_") && oWins == false && xWins == false) {
                    if (impossible == true) {
                        gameNotFinished = false;
                    } else {
                        gameNotFinished = true;
                    }
                } else if (!(matrix[i][j].contains("_")) && oWins == false && xWins == false && impossible == false) {
                    draw = true;
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    static String[][] matrix = new String[3][5];
    static int x = 0;
    static boolean xWins = false;
    static boolean oWins = false;
    static boolean gameNotFinished = false;
    static boolean draw = false;
    static boolean impossible = false;
    static int sumx = 0;
    static int sumo = 0;
    static int first;
    static int second;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
//        String initialState = "OXXXOOXO_";//scanner.next();
        String initialState = "_________";//scanner.next();
        String newS = initialState.replace("_", "");

        if (initialState.contains("_") && (initialState.contains("X") || initialState.contains("O"))) {
            for (String i : getConsecutiveOccurrenceOfChar(newS)) {
                if (i.split(" : ")[0].equals("X")) {
                    sumx += Integer.valueOf(i.split(" : ")[1]);
                } else if (i.split(" : ")[0].equals("O")) {
                    sumo += Integer.valueOf(i.split(" : ")[1]);
                }
            }
            System.out.println("sumx: " + sumx);
            System.out.println("sumo: " + sumo);
            if (sumx - sumo >= 2 || sumo - sumx >= 2) {
                impossible = true;
            }
        }

        // fill up initial state
        fillInitialMatrix(initialState);

        // print out matrix initial matrix
        printMatrix(matrix);

        StringBuilder temp = new StringBuilder(100);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                temp.append(matrix[i][j]);
            }
        }

        ////////////////////////////////////////////
        // start gry
        ////////////////////////////////////////////

        boolean xnow = true;
        boolean onow = false;

        while (temp.toString().contains("_")) {
            temp = new StringBuilder();

            System.out.print("Enter the coordinates: ");

            while (true) {
                while(!(scanner.hasNextInt()) ){
                    System.out.println("You should enter numbers!");

                }
                first = scanner.nextInt();
                second = scanner.nextInt();
                if(first > 3 || first < 1 || second > 3 || second < 1){
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates: ");
                } else {
                    break;
                }
            }

//            String field = scanner.nextLine();
//            StringBuilder tempStr = new StringBuilder(100);

            // remove blank spaces
//            for (int j = 0; j < field.length(); j++) {
//                if (!String.valueOf(field.charAt(j)).equals(" ")) {
//                    tempStr.append(field.charAt(j));
//                }
//            }

            if (first == 1 && second == 3) {
                first = 0;
                second = 1;
            } else if (first == 2 && second == 3) {
                first = 0;
                second = 2;
            } else if (first == 3 && second == 3) {
                first = 0;
                second = 3;
            } else if (first == 1 && second == 2) {
                first = 1;
                second = 1;
            } else if (first == 2 && second == 2) {
                first = 1;
                second = 2;
            } else if (first == 3 && second == 2) {
                first = 1;
                second = 3;
            } else if (first == 1 && second == 1) {
                first = 2;
                second = 1;
            } else if (first == 2 && second == 1) {
                first = 2;
                second = 2;
            } else if (first == 3 && second == 1) {
                first = 2;
                second = 3;
            }

            if (!matrix[first][second].equals("X") && !matrix[first][second].equals("O") && onow == false && xnow == true) {
                matrix[first][second] = "X";
                xnow = false;
                onow = true;
                // printing the matrix
                printMatrix(matrix);
            } else if (!matrix[first][second].equals("X") && !matrix[first][second].equals("O") && onow == true && xnow == false){
                matrix[first][second] = "O";
                xnow = true;
                onow = false;
                // printing the matrix
                printMatrix(matrix);
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }

            // check winning fields
            // first horizontal line check
            if (matrix[0][1].equals(matrix[0][2]) && matrix[0][2].equals(matrix[0][3])) {
                if (matrix[0][1].equals("X") && matrix[0][2].equals("X") && matrix[0][3].equals("X")) {
                    xWins = true;
                } else if (matrix[0][1].equals("O") && matrix[0][2].equals("O") && matrix[0][3].equals("O")) {
                    oWins = true;
                }
            }
            // 2nd horizontal line check
            if (matrix[1][1].equals(matrix[1][2]) && matrix[1][2].equals(matrix[1][3])) {
                if (matrix[1][1].equals("X") && matrix[1][2].equals("X") && matrix[1][3].equals("X")) {
                    xWins = true;
                } else if (matrix[1][1].equals("O") && matrix[1][2].equals("O") && matrix[1][3].equals("O")) {
                    oWins = true;
                }
            }
            // 3rd horizontal line check
            if (matrix[2][1].equals(matrix[2][2]) && matrix[2][2].equals(matrix[2][3])) {
                if (matrix[2][1].equals("X") && matrix[2][2].equals("X") && matrix[2][3].equals("X")) {
                    xWins = true;
                } else if (matrix[2][1].equals("O") && matrix[2][2].equals("O") && matrix[2][3].equals("O")) {
                    oWins = true;
                }
            }
            // cross check
            if (matrix[0][1].equals(matrix[1][2]) && matrix[1][2].equals(matrix[2][3])) {
                if (matrix[0][1].equals("X") && matrix[1][2].equals("X") && matrix[2][3].equals("X")) {
                    xWins = true;
                } else if (matrix[0][1].equals("O") && matrix[1][2].equals("O") && matrix[2][3].equals("O")) {
                    oWins = true;
                }
            }
            // cross check
            if (matrix[0][3].equals(matrix[1][2]) && matrix[1][2].equals(matrix[2][1])) {
                if (matrix[0][3].equals("X") && matrix[1][2].equals("X") && matrix[2][1].equals("X")) {
                    xWins = true;
                } else if (matrix[0][3].equals("O") && matrix[1][2].equals("O") && matrix[2][1].equals("O")) {
                    oWins = true;
                }
            }
            // 1st vertical line
            if (matrix[0][1].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][1])) {
                if (matrix[0][1].equals("X") && matrix[1][1].equals("X") && matrix[2][1].equals("X")) {
                    xWins = true;
                } else if (matrix[0][1].equals("O") && matrix[1][1].equals("O") && matrix[2][1].equals("O")) {
                    oWins = true;
                }
            }
            // 2nd vertical line
            if (matrix[0][2].equals(matrix[1][2]) && matrix[1][2].equals(matrix[2][2])) {
                if (matrix[0][2].equals("X") && matrix[1][2].equals("X") && matrix[2][2].equals("X")) {
                    xWins = true;
                } else if (matrix[0][2].equals("O") && matrix[1][2].equals("O") && matrix[2][2].equals("O")) {
                    oWins = true;
                }
            }
            // 3rd vertical line
            if (matrix[0][3].equals(matrix[1][3]) && matrix[1][3].equals(matrix[2][3])) {
                if (matrix[0][3].equals("X") && matrix[1][3].equals("X") && matrix[2][3].equals("X")) {
                    xWins = true;
                } else if (matrix[0][3].equals("O") && matrix[1][3].equals("O") && matrix[2][3].equals("O")) {
                    oWins = true;
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if (matrix[i][j].contains("_") && oWins == false && xWins == false) {
//                        if (impossible == true) {
//                            gameNotFinished = false;
//                        } else {
//                            gameNotFinished = true;
//                        }
                    } else if (!(matrix[i][j].contains("_")) && oWins == false && xWins == false /*&& impossible == false*/) {
                        draw = true;
                    }
                }
            }

            if (oWins && xWins) {
                System.out.println("Impossible");
                break;
            } else if (xWins) {
                System.out.println("X wins");
                break;
            } else if (oWins) {
                System.out.println("O wins");
                break;
            }
            else if (gameNotFinished) {
//                System.out.println("Game not finished");
                System.out.println("Draw");
            }
            else if (draw) {
                System.out.println("Draw");
                break;
            }
//            else if (impossible) {
//                System.out.println("Impossible");
//                break;
//            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    temp.append(matrix[i][j]);
                }
            }
        }
    }
}
