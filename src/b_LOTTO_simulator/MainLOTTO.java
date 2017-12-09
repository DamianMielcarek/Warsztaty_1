package b_LOTTO_simulator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainLOTTO {

    static Scanner scanner = new Scanner(System.in);
    static boolean isNumber;
    static int guessedNumber = 0;
    static int insertedNumberIndex = 0;
    static Integer[] arr = new Integer[6];
    static List<Integer> list = Arrays.asList(arr);
    static boolean isGuessedNumberInArray = Arrays.asList(arr).contains(guessedNumber);
    static int counter = 0;

    /*Warsztat: Symulator LOTTO.

    Jak wszystkim wiadomo, LOTTO to gra liczbowa polegająca na losowaniu 6 liczb z zakresu 1-49.
    Zadaniem gracza jest poprawne wytypowanie losowanych liczb.
    Nagradzane jest trafienie 3, 4, 5 lub 6 poprawnych liczb.

    Napisz program, który:

    * zapyta o typowane liczby, przy okazji sprawdzi następujące warunki:
        - czy wprowadzony ciąg znaków jest poprawną liczbą,
        - czy użytkownik nie wpisał tej liczby już poprzednio,
        - czy liczba należy do zakresu 1-49,
    * po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie,
    * wylosuje 6 liczb z zakresu i wyświetli je na ekranie,
    * poinformuje gracza, czy trafił przynajmniej "trójkę".

    Aby wylosować 6 liczb z zakresu 1-49 bez powtórzeń
    możemy utworzyć tablicę z wartościami 1-49,
    wymieszać jej zawartość i pobrać pierwsze 6 elementów.

    Poniższy kod powinien Ci pomóc:

        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        Collections.shuffle(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));

    Możesz również losować liczby z określonego
    zakresu (sprawdź w snippetach jak to wykonać) - jeżeli
    wybierzesz takie rozwiązanie,
    pamiętaj o sprawdzaniu
    czy dana wartość nie została wcześniej wylosowana.
    */
    public static void main(String[] args) {
        /*
        * zapyta o typowane liczby, przy okazji sprawdzi następujące warunki: // DONE
        - czy wprowadzony ciąg znaków jest poprawną liczbą, // DONE
        - czy użytkownik nie wpisał tej liczby już poprzednio, // DONE
        - czy liczba należy do zakresu 1-49, // DONE
        */
        System.out.println("Wprowadź 6 liczb:");
        while (list.contains(null)) {
            guessNumber();
        }
        System.out.println("Podano 6 liczb.");

        // po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie, // DONE
        Collections.sort(list);
        System.out.println(Arrays.toString(arr));

        // * wylosuje 6 liczb z zakresu i wyświetli je na ekranie, // DONE
        randomNumbers();

        // * poinformuje gracza, czy trafił przynajmniej "trójkę". // DONE
        if ( counter == 6) {
            System.out.println("WOW!!! Hura! Trafiłeś 6 !!!");
        } else if ( counter == 5 ) {
            System.out.println("Trafiłeś 5 !!");
        } else if (counter == 4) {
            System.out.println("Trafiłeś 4 !");
        } else if ( counter == 3) {
            System.out.println("Trafiłeś 3");
        }
    }

    static void randomNumbers() {
        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        Integer[] firstSixNumbersFromArr = Arrays.copyOfRange(arr, 0, 6);
        System.out.println(Arrays.toString(firstSixNumbersFromArr));
        for ( Integer el : firstSixNumbersFromArr ) {
            if ( list.contains(el) ) {
                counter++;
            }
        }
    }

    static void guessNumber() {
        try {
            scanner.useDelimiter("\\n");
            String input = scanner.next();
            guessedNumber = Integer.parseInt(input);
            if ( (guessedNumber > 0 && guessedNumber < 50) && (list.contains(guessedNumber)) ) {
                isNumber = false;
                System.out.println("Podana liczba została już podana wcześniej. Każdą liczbę można podać tylko raz. Podaj inną liczbę:");
            } else if ( guessedNumber > 0 && guessedNumber < 50 ) {
                isNumber = true;
            } else {
                isNumber = false;
                System.out.println("Podana liczba nie mieści się w zakresie 1 - 49. Podaj liczbę z tego zakresu:");
            }
            addGuessedNumberToArray();
        } catch (NumberFormatException e) {
            System.err.println("To nie jest liczba");
            isNumber = false;
        }
    }

    static void addGuessedNumberToArray() {
        if ( !(isGuessedNumberInArray) && (insertedNumberIndex <= arr.length - 1) && (isNumber == true) ) {
            arr[insertedNumberIndex] = guessedNumber;
            insertedNumberIndex++;
            System.out.println("Podano " + insertedNumberIndex + ". liczbę");
        } else {
            arr[insertedNumberIndex] = null;
        }
    }

}
