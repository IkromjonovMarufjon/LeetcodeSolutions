package uz.gita.part_1;

import java.util.*;
import java.util.function.BiConsumer;

public class Solution_1189 {

    public static void main(String[] args) {

    }

    public long sumAndMultiply(int n) {
        long x = 0L;
        int y = 0;

        String st = String.valueOf(n);
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) != '0') {
                x = x*10 + (st.charAt(i) - '0');
                y += (st.charAt(i) - '0');
            }
        }
        //10203004

        return x * y;
    }

    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern))
                count++;
        }
        return count;
    }

    public int[] recoverOrder(int[] order, int[] friends) {
        int[] result = new int[friends.length];
        int index = 0;

        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (order[i] == friends[j])  {
                    result[index ++] = order[i];
                    j = friends.length;
                }
            }
        }

        return result;
    }

    public long findTheArrayConcVal(int[] nums) {
        long sum = 0L;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[i] * Math.pow(10, count(nums[nums.length - 1 - i])) + nums[nums.length - 1 - i];
        }

        if (nums.length % 2 == 1) {
            int index = nums.length / 2 + 1;
            System.out.println(nums[index]);
            sum += nums[index];
        }

        return sum;
    }

    private int count(int x) {
        int c = 0;
        while (x > 0) {
            c++;
            x /= 10;
        }

        return c;
    }

    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums) {
            result.addAll(separate(num));
        }

        int[] x = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            x[i] = result.get(i);
        }

        return x;
    }

    private List<Integer> separate(int num) {
        ArrayList<Integer> ls = new ArrayList<>();

        while (num > 0) {
            ls.add(0, num % 10);
            num /= 10;
        }

        return ls;
    }

    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        String st = "balloon";

        for (int i = 0; i < st.length(); i++) {
            map.put(st.charAt(i), 0);
        }

        for (int i = 0; i < text.length(); i++) {
            if (map.containsKey(text.charAt(i)))
                map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }

        int[] min = new int[]{text.length()};

        map.forEach((key, value) -> {
            if ((key == 'b' || key == 'o')) {
                if (min[0] > value / 2) min[0] = value / 2;
            } else if (min[0] > value) min[0] = value;
        });

        return min[0];
    }

    public int subsetXORSum(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = 0;
            for (int j = i; j < nums.length; j++) {
                x = x ^ nums[i];
                sum += x;
            }
        }

        return sum;
    }
}


