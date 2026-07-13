package uz.gita.part_1;

public class Solution_3856 {
    public String trimTrailingVowels(String s) {
        String x = "aieuo";
        int lastIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (x.indexOf(s.charAt(i)) != -1)
                lastIndex = i;
        }

        if (lastIndex == -1) return "";
        return s.substring(0,lastIndex);
    }
}
