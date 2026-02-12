package uz.gita.part_1;

// https://leetcode.com/problems/reverse-letters-then-special-characters-in-a-string/description/?envType=problem-list-v2&envId=string

public class Solution_3823 {
    public static void main(String[] args) {
        System.out.println(reverseByType(")ebc#da@f("));
    }

    public static String reverseByType(String s) {
        StringBuilder sb = new StringBuilder();
        int letterIndex = s.length() - 1;
        int symbolIndex = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                while (!Character.isLetter(s.charAt(letterIndex))) {
                    letterIndex --;
                }
                sb.append(s.charAt(letterIndex --));
            } else {
                while (Character.isLetter(s.charAt(symbolIndex))) {
                    symbolIndex --;
                }
                sb.append(s.charAt(symbolIndex --));
            }
        }

        return sb.toString();
    }
}

/*
Input: s = ")ebc#da@f("

Output: "(fad@cb#e)"
* */