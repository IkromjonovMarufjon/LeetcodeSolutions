package uz.gita.part_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;

public class Solution_3866 {

//    public int totalNumbers(int[] digits) {
//        Set<Integer> set = new HashSet<>();
//
//        for (int i = 0; i < digits.length; i++) {
//            for (int j = 0; j < digits.length; j++) {
//                if (i == j) continue;
//
//                for (int k = j + 1; k < digits.length; k++) {
//                    if (k == j) continue;
//                    if (digits[k] % 2 == 0)
//                        set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
//                }
//            }
//        }
//
//        for
//
//        return set.size();
//    }

    public int secondsBetweenTimes(String startTime, String endTime) {
        return calculateSecond(endTime) - calculateSecond(startTime);
    }

    private int calculateSecond(String time) {
//        HH:MM:SS
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        int s = Integer.parseInt(time.substring(6));

        return h * 3600 + m * 60 + s;
    }

    public int[] concatWithReverse(int[] nums) {
        int[] result = Arrays.copyOf(nums, 2 * nums.length);

        for (int i = 0; i < nums.length; i++) {
            result[nums.length + i] = nums[nums.length - i - 1];
        }

        return result;
    }

    public int minimumDistance(int[] nums) {
        if (nums.length < 3) return -1;
        if (nums.length == 3) {
            if (nums[0] == nums[1] && nums[0] == nums[2])
                return 4;
            else return -1;
        }

        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[j] == nums[k]) {
                            sum = Math.min(sum, (k - j) + (j - i) + (k - i));
                        }
                    }
                }
            }
        }

        if (sum == Integer.MAX_VALUE) return -1;
        return sum;
    }

    public int smallestNumber(int n, int t) {
        while (n < Integer.MAX_VALUE) {
            if (sumOfDigits(n) % t == 0)
                return n;

            n++;
        }

        return Integer.MAX_VALUE;
    }

    private int sumOfDigits(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }

    public int firstUniqueEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[]{-1};
        map.forEach(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer key, Integer value) {
                if (result[0] != -1 && key % 2 == 0 && value == 1)
                    result[0] = key;
            }
        });

        return result[0];
    }

}


