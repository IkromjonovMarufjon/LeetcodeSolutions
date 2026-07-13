package uz.gita.part_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_2778 {

    public int maxSum(int[] nums) {
        int[] digits = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            digits[i] = max(nums[i]);
        }

        int max = -1;
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] == digits[j])
                    if (max < nums[i] + nums[j])
                        max = (nums[i] + nums[j]);
            }
        }

        return max;
    }

    private int max(int x) {
        List<Integer> ls = new ArrayList<>();
        while (x > 0) {
            ls.add(x % 10);
            x /= 10;
        }

        Collections.sort(ls);
        return ls.get(ls.size() - 1);
    }
}

