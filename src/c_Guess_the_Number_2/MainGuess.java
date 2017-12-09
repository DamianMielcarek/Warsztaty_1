package c_Guess_the_Number_2;

import java.util.Scanner;

public class MainGuess {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int max = 1000;


        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max. 10 próbach\n");
        System.out.println("Napisz: \n" +
                "zgadłeś, jeśli zgadłem;\n" +
                "za dużo, jeśli podałem za wysoką liczbę;\n" +
                "za mało, jeśli podałem za niską liczbę.\n");

        while (true) {
            System.out.println("Zgaduję: " + guess(min,max));

            scanner.useDelimiter("\\n");
            String input = scanner.next();

            if ( input.equals("zgadłeś") ) {
                System.out.println("Wygrałem");
                break;
            } else if ( input.equals("za dużo") ) {
                max = guess(min, max);
            } else if ( input.equals("za mało") ) {
                min = guess(min, max);
            } else {
                System.out.println("nie oszukuj!");
                System.out.println("Zgaduję: " + guess(min, max));
            }
        }

    }

    static int guess(int min, int max) {
        return ( (max - min) / 2 ) + min;
    }

}
