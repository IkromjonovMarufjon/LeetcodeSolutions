package uz.gita.part_1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution_3442 {

    public int[][] flipAndInvertImage(int[][] image) {
        int[] temp = new int[image[0].length];

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                 if(image[i][image[i].length - 1 - j] == 0) temp[j] = 1;
                 else temp[j] = 0;
            }
            System.out.println(Arrays.toString(temp));
            image[i] = Arrays.copyOf(temp, temp.length);
        }

        return image;
    }

    public int maxDifference(String s) {
        int[] mass = new int[26];

        for (int i = 0; i < s.length(); i++) {
            mass[s.charAt(i) - 'a'] ++;
        }

        Arrays.sort(mass);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 26; i++) {
            if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE)
                i = 26;

            if (max == Integer.MIN_VALUE && max < mass[i] && mass[i] % 2 == 1)
                max = mass[i];

            if (min == Integer.MAX_VALUE && min > mass[i] && mass[i] % 2 == 0)
                min = mass[i];
        }

        return max - min;
    }
}
