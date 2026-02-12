package uz.gita.part_1;

public class Solution_3330 {

    public int possibleStringCount(String word) {
        int result = 0;
        int count = 0;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i-1)) {
                count ++;
            } else {
                result += count;
                count = 0;
            }
        }

        return result;
    }
}


