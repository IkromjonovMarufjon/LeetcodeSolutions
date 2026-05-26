package uz.gita.part_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

public class Solution_1636 {

    public static void main(String[] args) {
        int[] mass = new int[]{-1,1,-6,4,5,-6,1,4,1};
        frequencySort(mass);
    }

    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        Integer[] temp = new Integer[nums.length];

        for (int i = 0; i < nums.length; i ++) {
            maps.put(nums[i], maps.getOrDefault(nums[i], 0) + 1);
            temp[i] = nums[i];
        }


        Arrays.sort(temp, new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                if (Objects.equals(maps.get(a), maps.get(b)))
                    return b - a;
                else return maps.get(a) - maps.get(b);
            }
        });

        System.out.println(Arrays.toString(temp));

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

        System.out.println(Arrays.toString(nums));

        return nums;
    }
}

// [-1,1,-6,4,5,-6,1,4,1]
// [5,-1,4,4,-6,-6,1,1,1]



