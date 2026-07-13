package uz.gita.part_1;

public class Solution_3931 {

    public static void main(String[] args) {

    }
    public boolean isAdjacentDiffAtMostTwo(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) > 2)
                return false;
        }

        return true;
    }
}
