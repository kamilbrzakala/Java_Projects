package machine;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {

    public static int[] statusOfIngredients(int water, int milk, int beans, int expressWaterSize, int expressMilkSize, int expressBeansSize, int price, int money, int disposableCups) {

        int waterLeft = expressWaterSize - water;
        int milkLeft = expressMilkSize - milk;
        int beansLeft = expressBeansSize - beans;
        int moneyLeft = money + price;
        int cupsLeft = disposableCups - 1;

        System.out.println("The coffee machine has:");
        System.out.println(waterLeft + " of water");
        System.out.println(milkLeft + " of milk");
        System.out.println(beansLeft + " of coffee beans");
        System.out.println(cupsLeft + " of disposable cups");
        System.out.println(moneyLeft + " of money");

        return new int[] {waterLeft,milkLeft,beansLeft,moneyLeft,cupsLeft};
    }

    public static void fillExpress (int water, int milk, int beans, int expressWaterSize, int expressMilkSize, int expressBeansSize, int price, int money, int disposableCups, int newCups) {

        int waterLeft = expressWaterSize + water;
        int milkLeft = expressMilkSize + milk;
        int beansLeft = expressBeansSize + beans;
        int moneyLeft = money + price;
        int cupsLeft = disposableCups + newCups;

        System.out.println("The coffee machine has:");
        System.out.println(waterLeft + " of water");
        System.out.println(milkLeft + " of milk");
        System.out.println(beansLeft + " of coffee beans");
        System.out.println(cupsLeft + " of disposable cups");
        System.out.println(moneyLeft + " of money");
    }

    public static void giveMoneyAway (int water, int milk, int beans, int expressWaterSize, int expressMilkSize, int expressBeansSize, int price, int money, int moneyAway,int disposableCups, int newCups) {

        int waterLeft = expressWaterSize + water;
        int milkLeft = expressMilkSize + milk;
        int beansLeft = expressBeansSize + beans;
        int moneyLeft = money - moneyAway;
        int cupsLeft = disposableCups + newCups;

        System.out.println("The coffee machine has:");
        System.out.println(waterLeft + " of water");
        System.out.println(milkLeft + " of milk");
        System.out.println(beansLeft + " of coffee beans");
        System.out.println(cupsLeft + " of disposable cups");
        System.out.println(moneyLeft + " of money");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = null;

        int expressWaterSize = 400; // default size
        int water = 0; // bedzie liczone pozniej

        int expressMilkSize = 540; // default size
        int milk = 0;

        int expressBeansSize = 120; // default size
        int beans = 0;

        int disposableCups = 9;
        int newCups= 0;

        int money = 550;

        System.out.println("The coffee machine has:");
        System.out.println(expressWaterSize + " of water");
        System.out.println(expressMilkSize + " of milk");
        System.out.println(expressBeansSize + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");

        System.out.println("Write action (buy, fill, take):");
        String action = scanner.next(); // buy, fill, take

        switch (action) {

            case "buy":

                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");

                switch (scanner.nextInt()) {// 1 - espresso, 2 - latte, 3 - cappuccino
                    case 1: // espresso
                        statusOfIngredients(250,0,16,expressWaterSize,expressMilkSize,expressBeansSize,4,money,disposableCups);
                        arr = statusOfIngredients(250,0,16,expressWaterSize,expressMilkSize,expressBeansSize,4,money,disposableCups);
                        System.out.println(Arrays.toString(arr));
                        break;
                    case 2: // latte
                        statusOfIngredients(350,75,20,expressWaterSize,expressMilkSize,expressBeansSize,7,money,disposableCups);
                        break;
                    case 3: // cappuccino
                        statusOfIngredients(200,100,12,expressWaterSize,expressMilkSize,expressBeansSize,6,money,disposableCups);
                        break;
                    default:
                        break;
                }
                break;

            case "fill":

                System.out.println("Write how many ml of water do you want to add:");
                water = scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                milk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                beans = scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                newCups = scanner.nextInt();

                fillExpress(water,milk,beans,expressWaterSize,expressMilkSize,expressBeansSize,0,money,disposableCups,newCups);
                break;

            case "take":
                giveMoneyAway(0,0,0,expressWaterSize,expressMilkSize,expressBeansSize,0,money,money,disposableCups,0);
                break;
            default:
                break;

        }

//        System.out.print("Starting to make a coffee\n");
//        System.out.print("Grinding coffee beans\n");
//        System.out.print("Boiling water\n");
//        System.out.print("Mixing boiled water with crushed coffee beans\n");
//        System.out.print("Pouring coffee into the cup\n");
//        System.out.print("Pouring some milk into the cup\n");
//        System.out.print("Coffee is ready!");
    }
}
