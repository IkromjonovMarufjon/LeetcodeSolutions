package uz.gita.part_1;

public class Solution_3813 {

    public int vowelConsonantScore(String s) {
        String st = "aeiou";
        int v = 0, c = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i)))
                continue;
            if (st.indexOf(s.charAt(i)) == -1) c ++;
            else v ++;
        }

        if (v == 0) return 0;
        return c / v;
    }
}

