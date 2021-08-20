//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class DayFour {
    ArrayList<Integer> passwords = new ArrayList();

    public DayFour() {
    }

    public static void main(String[] args) {
        (new DayFour()).run();
    }

    void run() {
        for(int guess = 147981; guess <= 691423; ++guess) {
            if (!this.hasDecreasingDigits(guess) && !this.hasNoAdjacentDoubles(guess)) {
                System.out.println(guess);
                this.passwords.add(guess);
            }
        }

        System.out.println(this.passwords.size());
    }

    boolean hasDecreasingDigits(int guess) {
        String str = String.valueOf(guess);

        for(int i = 0; i < str.length() - 1; ++i) {
            int a = Integer.parseInt(str.substring(i, i + 1));
            int b = Integer.parseInt(str.substring(i + 1, i + 2));
            if (a > b) {
                return true;
            }
        }

        return false;
    }

    boolean hasNoAdjacentDoubles(int guess) {
        String str = String.valueOf(guess);

        for(int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1) && this.exactlyTwoDoubles(str, i)) {
                return false;
            }
        }

        return true;
    }

    boolean exactlyTwoDoubles(String guess, int start) {
        int previousIndex = start - 1;
        int nextIndex = start + 2;
        String firstDigit = guess.substring(start, start + 1);
        return this.isDifferent(guess, firstDigit, previousIndex) && this.isDifferent(guess, firstDigit, nextIndex);
    }

    boolean isDifferent(String guess, String firstDigit, int indexToCheck) {
        try {
            String digitToCheck = String.valueOf(guess.charAt(indexToCheck));
            return !firstDigit.equals(digitToCheck);
        } catch (IndexOutOfBoundsException var5) {
            return true;
        }
    }
}
