package uz.gita.part_1;

public class Solution_1920 {

    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }

        return result;
    }
}

// [5, 0, 1, 2, 3, 4]
// [0, 0, 0, 0, 0, 0]


