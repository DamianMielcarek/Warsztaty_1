package a_Guess_the_Number;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean isNumber;
    static int randomNumber = -1;
    static int guessedNumber = 0;

    public static void main(String[] args) {
        randomNumber();
        int step = 1;
        while ( guessedNumber != randomNumber ) {
            if (step == 1) {
                System.out.println("Zgadnij liczbę:");
                guessNumber();
                if (isNumber == false) {
                    step = 1;
                } else {
                    step = 2;
                }
            } else if (step == 2) {
                if ( guessedNumber < randomNumber) {
                    System.out.println("Za mało!");
                    step = 1;
                } else if ( guessedNumber > randomNumber) {
                    System.out.println("Za dużo!");
                    step = 1;
                } else if ( guessedNumber == randomNumber) {
                    break;
                }
            }
        }
        System.out.println("Zgadłeś!");
    }

    static int randomNumber() {
        int minimum = 1;
        int maximum = 100;

        /** // from Java 8
        Random random = new Random();
        int[] fiveRandomNumbers = random.ints(5, 0, 11).toArray();
        int randomNumber = random.ints(1, 0, 11).findFirst().getAsInt();*/

        /** // from Java 7
        // nextInt is normally exclusive of the top value, so add 1 to make it inclusive*/
        randomNumber = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
        /***/

        /** // before Java 7
        Random random = new Random();int randomNumber = minimum + random.nextInt((maximum - minimum) + 1);*/
        return randomNumber;
    }

    static int guessNumber() {
        try {
            guessedNumber = Integer.parseInt(myScanner());
            isNumber = true;
        } catch (NumberFormatException e) {
            System.err.println("To nie jest liczba");
            isNumber = false;
        }
        return guessedNumber;
    }

    static String myScanner() {
        String input = scanner.nextLine();
        return input;
    }
}
