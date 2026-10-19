package uz.gita.part_1;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Solution_2540 {

//    public boolean equalFrequency(String word) {
//        int[] arr = new int[26];
//        for (int i = 0; i < word.length(); i++) {
//            arr[word.charAt(i) - 'a'] ++;
//        }
//
//        for (int i = 0; i < 26; i++) {
//            if (arr[i] == 0) continue;
//            arr[i] --;
//            int x = -1;
//            for (int j = 0; j < 26; j++) {
//                if (arr[j] == 0) continue;
//                if (x == -1) x = arr[j];
//                else if (x != arr[j]) {
//
//                }
//            }
//        }
//    }

    public int countCompleteDayPairs(int[] hours) {
        int count = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0)
                    count ++;
            }
        }

        return count;
    }

    public int duplicateNumbersXOR(int[] nums) {
        int[] mass = new int[51];
        for (int num :nums) {
            mass[num] ++;
        }
        int sum = 0;
        for (int j = 0; j < mass.length; j ++) {
            if (mass[j] == 2){
                System.out.println(j);
                sum ^= j;
            }
        }

        return sum;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < dominoes.length; i++) {
            int temp = dominoes[i][0] * 10 + dominoes[i][1];
            if (map.containsKey(temp)) {
                count += map.getOrDefault(temp, 0);
                map.put(temp, map.getOrDefault(temp, 0) - 1);
                continue;
            }

            int temp2 = dominoes[i][1] * 10 + dominoes[i][0];
            if (map.containsKey(temp2)) {
                count += map.getOrDefault(temp2, 0);
                map.put(temp2, map.getOrDefault(temp2, 0) - 1);
                continue;
            }

            int x = 0;
            for (int j = i + 1; j < dominoes.length; j++) {
                if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) ||
                        (dominoes[i][1] == dominoes[j][0] && dominoes[i][0] == dominoes[j][1])) {
                    x ++;
                }

                map.put(dominoes[i][0] * 10 + dominoes[i][1], x);
            }
        }

        return count;
    }


    public int getCommon(int[] nums1, int[] nums2) {
        int result = -1;
        int i1 = 0, i2 = 0;

        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                result = nums2[i2];
                i1 = nums1.length;
                i2 = nums2.length;
            }

            else if (nums1[i1] > nums2[i2]) {
                i2 ++;
            }
            else if (nums1[i1] < nums2[i2]) {
                i1++;
            }
        }


        return result;
    }
}
