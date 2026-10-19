package uz.gita.part_2;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Solution_2423 {
    public static void main(String[] args) {
        System.out.println("------------------------ case 1 ------------------------");
        System.out.println("true = " + allElementAmountEqualsOne(new int[]{1,1,1,1,0}));
        System.out.println("false = " + allElementAmountEqualsOne(new int[]{1,2,1,1,0}));
        System.out.println("true = " + allElementAmountEqualsOne(new int[]{1}));

        System.out.println("------------------------ case 2 ------------------------");
        System.out.println("true = " + onlySingleElementOtherFewBigger(new int[]{5,5,6}));
        System.out.println("true = " + onlySingleElementOtherFewBigger(new int[]{5,5,6,5}));
        System.out.println("false = " + onlySingleElementOtherFewBigger(new int[]{5,5,5}));
        System.out.println("false = " + onlySingleElementOtherFewBigger(new int[]{4,5,5,5}));
        System.out.println("false = " + onlySingleElementOtherFewBigger(new int[]{4,5,5,4}));
        System.out.println("true = " + onlySingleElementOtherFewBigger(new int[]{4,5,4,4}));

        System.out.println("------------------------ case 3 ------------------------");
        System.out.println("true = " + hasOneAmountOnlyOneTime(new int[]{5,5,5,1}));
        System.out.println("true = " + hasOneAmountOnlyOneTime(new int[]{2,1}));
        System.out.println("true = " + hasOneAmountOnlyOneTime(new int[]{2,1}));
        System.out.println("false = " + hasOneAmountOnlyOneTime(new int[]{2,3}));
        System.out.println("false = " + hasOneAmountOnlyOneTime(new int[]{2,3,3,3,3}));
        System.out.println("false = " + hasOneAmountOnlyOneTime(new int[]{2,3,2,2,2,2}));
        System.out.println("false = " + hasOneAmountOnlyOneTime(new int[]{2,3,2,2,1,2,2}));
    }

    public static boolean equalFrequency(String word) {
        if (word.isEmpty()) return true;
        int[] letters = new int[26];
        for (int i = 0; i < word.length(); i++) {
            letters[word.charAt(i) - 'a'] ++;
        }

        if (onlyOneElementBiggerZero(letters)) {
            System.out.println("onlyOneElementBiggerZero");
            return true;
        }

        if (allElementAmountEqualsOne(letters)) {
            System.out.println("allElementAmountEqualsOne");
            return true;
        }

        if (onlySingleElementOtherFewBigger(letters)) {
            System.out.println("onlySingleElementOtherFewBigger");
            return true;
        }

        if (hasOneAmountOnlyOneTime(letters)) {
            System.out.println("hasOneAmountOnlyOneTime");
            return true;
        }
        return false;
    }

    /**
     *  faqat bitta 0 dan farqli qiymat bor
     */
    private static boolean onlyOneElementBiggerZero(int[] letters) {
        int count = 0;
        for (int letter: letters) {
            if (letter > 0) count ++;
        }

        return count == 1;
    }

    /**
     *   hamma elementlari birga teng bo'lsa:  "asd", "a", "qwerty"
     */
    private static boolean allElementAmountEqualsOne(int[] letters) {
        for (int letter: letters) {
            if (letter > 1) return false;
        }
        return true;
    }

    /**
     *  hamma elementlari qiymati teng, faqat bittasi qolganlarida bittaga ko'p bo'lsa:   "aaaabbbbkkk", "aaaabbbbkkkkk"
     */
    private static boolean onlySingleElementOtherFewBigger(int[] letters) {
        int x = 0, countX = 0;
        int y = 0, countY = 0;

        for(int letter: letters) {
            if (letter == 0) continue;
//            System.out.println(letter);
            if (x == 0) {
                x = letter;
                countX ++;
                continue;
            }
            if (letter == x) {
                countX ++;
                continue;
            }
            if (y == 0) {
                y = letter;
                countY ++;
                continue;
            }
            if (letter == y) {
                countY ++;
                continue;
            }
            return false;
        }
//        System.out.println(x + " - " + countX);
//        System.out.println(y + " - " + countY);
        if (countX == 1 && x - y == 1) return true;
        if (countY == 1 && y - x == 1) return true;
        return false;
    }

    /**
     *  hamma elementlari qiymati teng, orasida faqat bittasini qiymati birga teng
     */

    private static boolean hasOneAmountOnlyOneTime(int[] letters) {
        int x = 0, countX = 0;
        int y = 0, countY = 0;

        for(int letter: letters) {
            if (letter == 0) continue;
//            System.out.println(letter);
            if (x == 0) {
                x = letter;
                countX ++;
                continue;
            }
            if (letter == x) {
                countX ++;
                continue;
            }
            if (y == 0) {
                y = letter;
                countY ++;
                continue;
            }
            if (letter == y) {
                countY ++;
                continue;
            }
            return false;
        }

        if (countX == 1 && x == 1) return true;
        if (countY == 1 && y == 1) return true;
        return false;
    }
}


