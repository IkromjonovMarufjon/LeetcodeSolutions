package uz.gita.part_2;

import java.util.*;
import java.util.function.BiConsumer;

public class Solution_3318 {

//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num: nums)
//            map.put(num, map.getOrDefault(num, 0) + 1);
//
//        ArrayList<Integer> ls = new ArrayList<>(map.values());
//        ls.sort(Comparator.comparingInt(o -> o));
//        List<Integer> subList = ls.subList(ls.size() - k - 1, ls.size());
//        int[] result = new int[k];
//        int[] index = {0};
//        map.forEach((key, value) -> {
//            if (subList.contains(value))
//                result[index[0] ++] = key;
//        });
//        return result;
//    }

    public static void main(String[] args) {
        //[]
//        topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2}, 2);
        System.out.println(equalFrequency("ddaccb"));
//        System.out.println(equalFrequency("cazz"));
    }

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0;

        for (int i = lowLimit; i <= highLimit ; i++) {
            s = sumOfNumber(i);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int[] max = { 0 };
        map.forEach((key, value) -> {
            if (max[0] < value)
                max[0] = value;
        });

        return max[0];
    }

    private int sumOfNumber(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static boolean equalFrequency(String word) {
        if (word.isEmpty()) return false;

        int[] letters = new int[26];
        for (int i = 0; i < word.length(); i++) {
            letters[word.charAt(i) - 'a'] ++;
        }
        if (checkAllEqualsOne(letters)) {
            System.out.println("checkAllEqualsOne");
            return true;
        }
        if (checkHasOneOnlyOneTime(letters) || checkHasBiggerToOneOnlyOneTime(letters)) {
            System.out.println("checkHasTwoOnlyOneTime");
            return true;
        }
        return checkOneAmountDifferentCount(letters);
    }

    private static boolean checkAllEqualsOne(int[] mass) {
        for (int j : mass) {
            if (j > 1) return false;
        }
        return true;
    }
    private static boolean checkHasOneOnlyOneTime(int[] mass) {
        int count = 0;
        for (int j : mass) {
            if (j == 1) count++;
        }

        return count == 1;
    }

    private static boolean checkHasBiggerToOneOnlyOneTime(int[] mass) {
        int count = 0;
        int x = 0;
        for (int j : mass) {
            if (j == 1) count++;
            if (j > 0) x ++;
        }

        return x - count == 1;
    }

    private static boolean checkOneAmountDifferentCount(int[] letters) {   //baacbcc
        int x = 0;
        int y = 0;

        System.out.println(Arrays.toString(letters));
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == 0) continue;
            if (letters[i] == x || letters[i] == y) continue;
            if (x == 0) {
                x = letters[i];
                continue;
            }
            if (y == 0) {
                y = letters[i];
                continue;
            }
            return false;
        }

        System.out.println("X = " + x);
        System.out.println("Y = " + y);
        return Math.abs(x- y) == 1;
    }


    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return new int[10];
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k; i++) {
            result[i] = calculate(nums, i, k, x);
        }
        return result;
    }

    private int calculate(int[] nums, int start, int k, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < start + k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return 0;
    }
}



