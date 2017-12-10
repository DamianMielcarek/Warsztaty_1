package d_Dice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainDice {

    private static int randomNumber = -1;

    public static void main(String[] args) {
        System.out.println("Wynik dla podanego rzutu to: " + diceThrow());
    }

    private static int diceThrow() {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] inputsArr;
        boolean doMatch;
        boolean containsPlus;
        boolean containsMinus;
        boolean isNullStringInArray;
        int whatDice;
        int howManyDiceThrows;
        int result = 0;

        System.out.println("Jaki rzut?\n" +
                "\n" +
                "Przykłady:\n" +
                "\n" +
                "    - 2D10+10: 2 rzuty D10, do wyniku dodaj 10,\n" +
                "    - D6: zwykły rzut kostką sześcienną,\n" +
                "    - 2D3: rzut dwiema kostkami trójściennymi,\n" +
                "    - D12-1: rzut kością D12, od wyniku odejmij 1.");

        input = scanner.next();
        doMatch = input.matches("[0-9]{0,3}D[0-9]{1,3}(\\+|-)?[0-9]{0,3}");

        if (doMatch) {
            inputsArr = input.split("D|\\+|\\-");
            containsPlus = input.contains("+");
            containsMinus = input.contains("-");

            isNullStringInArray = Arrays.asList(inputsArr).contains("");

            whatDice = Integer.parseInt(inputsArr[1]);
            howManyDiceThrows = 0;
            if (isNullStringInArray) {
                inputsArr[0] = String.valueOf(1);
            } else {
                howManyDiceThrows = Integer.parseInt(inputsArr[0]);
            }
            result = calculations(result, inputsArr, whatDice, howManyDiceThrows, isNullStringInArray, containsMinus, containsPlus);
        } else {
            System.err.println("Don't match");
        }
        return result;
    }

    private static int calculations(int result, String[] inputsArr, int whatDice, int howManyDiceThrows, boolean isNullStringInArray, boolean containsMinus, boolean containsPlus) {
        if (isNullStringInArray) {
            result = calculations2(result, whatDice, inputsArr, containsMinus, containsPlus);
        } else {
            for (int i = 0; i < howManyDiceThrows; i++) {
                result = calculations2(result, whatDice, inputsArr, containsMinus, containsPlus);
            }
        }
        return result;
    }

    private static int calculations2(int result, int whatDice, String[] inputsArr, boolean containsMinus, boolean containsPlus) {
        if (inputsArr.length == 2)
            result = randomNumber(whatDice);
        else if (containsMinus)
            result = randomNumber(whatDice) - Integer.parseInt(inputsArr[2]);
        else if (containsPlus)
            result = randomNumber(whatDice) + Integer.parseInt(inputsArr[2]);
        return result;
    }

    private static int randomNumber(int maximum) {
        int minimum = 1;
        randomNumber = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
        return randomNumber;
    }

}
