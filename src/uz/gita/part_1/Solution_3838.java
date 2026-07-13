package uz.gita.part_1;

public class Solution_3838 {
    public String mapWordWeights(String[] words, int[] weights) {
        int[] mass = new int[words.length];
        int sum = 0;

        for (int i = 0; i < words.length; i++) {
            sum = 0;
            for (int j = 0; j < words[i].length(); j++) {
                sum += weights[words[i].charAt(j) - 'a' + 1];
            }
            mass[i] = sum % 26;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
            sb.append((char)((26 - mass[i] - 1) + 'a'));
        }

        return sb.toString();
    }
}
