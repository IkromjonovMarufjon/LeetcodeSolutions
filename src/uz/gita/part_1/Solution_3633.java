package uz.gita.part_1;

import java.util.*;

public class Solution_3633 {

    public static void main(String[] args) {
//        System.out.println(isGood(new int[]{1, 2, 2}));
        System.out.println(isGood(new int[]{1, 3, 3, 2}));
    }

//    public double trimMean(int[] arr) {
//        Arrays.sort(arr);
//        int x = (int) (arr.length * 0.05);
//        long sum = 0;
//
//        for (int i = x +1; i <arr.length - x ; i++) {
//            sum += arr[i];
//        }
//
//        return (sum * 1.0 / (arr.length - 2 * x)) * 100000 / 100000;
//    }

    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;

        for (int j : salary) {
            if (min > j)
                min = j;

            if (max < j)
                max = j;

            sum += j;
        }

        return ((sum - min - max) * 1.0/ (salary.length - 2))* 100000 / 100000 ;
    }

    public int minDeletion(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),  0) + 1);
        }

        ArrayList<Integer> ls = new ArrayList<>(map.values());
        Collections.sort(ls);

        int sum = 0, x = ls.size() - k;
        for (int i = 0; i < x; i++) {
            sum += ls.get(i);
        }

        return sum;
    }

    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int[] x = new int[100];

        for (Integer bulb : bulbs) {
            if (x[bulb] == 0) x[bulb] = 1;
            else x[bulb] = 0;
        }

        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (x[i] != 0) ls.add(i);
        }

        return ls;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num < pivot)
                result[index++] = num;
        }
        for (int num : nums) {
            if (num == pivot)
                result[index++] = num;
        }
        for (int num : nums) {
            if (num > pivot)
                result[index++] = num;
        }

        return result;
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int i = 0; i < apple.length; i++) {
            sum += apple[i];
        }

        Arrays.sort(capacity);
        for (int i = capacity.length -1; i >= 0; i--) {
            sum -= capacity[i];
            if (sum <= 0)
                return capacity.length - i;
        }

        return capacity.length;
    }

    public static boolean isGood2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] - nums[0] != 1)
                return false;
        }

        return nums[nums.length - 2] == nums[nums.length - 1];
    }

    public static boolean isGood(int[] nums) {
        int x = nums.length - 1;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int sum2 = (1 + x)* x / 2 + x;

        System.out.println(sum);
        System.out.println(sum2);
        return sum == sum2;
    }

    public int totalWaviness(int num1, int num2) {
        int count = 0;

        for (int i = num1; i <num2 ; i++) {
            count += counter(i);
        }
        return count;
    }

    public int counter(int num) {
        if (num < 100) return 0;
        if (num < 1000) {
            int birlik = num % 10;
            int onlik = (num % 100) / 10;
            int yuzlik = num / 100;

            if (birlik < onlik && onlik > yuzlik) return 1;
            if (birlik > onlik && onlik < yuzlik) return 1;
            return 0;
        }

        if (num < 10000) {
            int birlik = num % 10;
            int onlik = (num % 100) / 10;
            int yuzlik = (num % 1000) / 100;
            int minlik = num / 1000;

            int count = 0;
            if (minlik < yuzlik && yuzlik > onlik) count ++;
            if (minlik > yuzlik && yuzlik < onlik) count ++;

            if (yuzlik < onlik && onlik > birlik) count ++;
            if (yuzlik > onlik && onlik < birlik) count ++;

            return count;
        }

        int count = 0;

        int birlik = num % 10;
        int onlik = (num % 100) / 10;
        int yuzlik = (num % 1000) / 100;
        int minlik = (num % 10_000)/ 1000;
        int onminglik = num / 10_000;

        if (onminglik < minlik && minlik > yuzlik) count ++;
        if (onminglik > minlik && minlik < yuzlik) count ++;

        if (minlik < yuzlik && yuzlik > onlik) count ++;
        if (minlik > yuzlik && yuzlik < onlik) count ++;

        if (yuzlik < onlik && onlik > birlik) count ++;
        if (yuzlik > onlik && onlik < birlik) count ++;

        return count;
    }


    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];

        int index = 0;
        for (int i = nums.length - 1;  i >= 0 ; i --) {
            if (result[index] != nums[i])
                result[index ++ ] = nums[i];

            if (index == k) return result;
        }

        return Arrays.copyOf(result, index);

    }

    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[nums.length - 1 - i] - nums[i];
        }

        return (int) sum;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;

        int sum = 0;

        for (int i = 0; i < landStartTime.length; i++) {
            sum = landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {
                if (sum <= waterStartTime[j])
                    sum = waterStartTime[j];

                else sum += waterDuration[j];

                min = Math.min(min, sum);
            }
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            sum = waterStartTime[i] + waterDuration[i];

            for (int j = 0; j < landStartTime.length; j++) {
                if (sum <= landStartTime[j])
                    sum = landStartTime[j];

                else sum += landDuration[j];

                min = Math.min(min, sum);
            }
        }

        return min;
    }
}

/*
landStartTime  =   [66,41]   [2,8]
landDuration   =   [34,37]   [4,1]
waterStartTime =   [99,17]   [6]
waterDuration  =   [59,36]   [3]
* */