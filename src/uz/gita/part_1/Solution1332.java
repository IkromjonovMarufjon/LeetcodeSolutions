package uz.gita.part_1;

import java.util.*;
import java.util.function.BiConsumer;

public class Solution1332 {

    public static void main(String[] args) {
//        isPalindromic("vn");
        System.out.println(countSpecialIntegers(new int[]{8,8,8,8,8,8,8}));
        System.out.println(countSpecialIntegers(new int[]{1,2,1,3,6,3,3,3,4,5,6,8}));
        System.out.println(countSpecialIntegers(new int[]{1,2,1,3,7,3,3,3,4,5,6,8}));
    }

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (sum(nums[i]) == i)
                return i;
        }
        return -1;
    }

    private int sum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    public boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder(s);
        String sReverse = sb.reverse().toString();

        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (sReverse.contains(s.substring(i, i + 2)))
                count ++;
        }

        return count > 0;
    }

    public int countSpecialIntegers2(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> ls = map.getOrDefault(nums[i], new ArrayList<>());
            ls.add(i);
            map.put(nums[i], ls);
        }

        int[] count = {0};
        map.forEach((key, values) -> {
            if (values.size() == 3) {
                if (values.get(0) - values.get(1) == values.get(1) - values.get(2))
                    count[0] ++;
            }
        });

        return count[0];
    }

    public static int countSpecialIntegers(int[] nums) {
        Set<Integer> all = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                all.add(nums[i]);
                set.add(nums[i]);
            } else {
                if (nums[i] == nums[i - 1]) continue;
                else {
                    if (all.contains(nums[i]))
                        set.remove(nums[i]);
                    else set.add(nums[i]);
                    all.add(nums[i]);
                }
            }
        }

        return set.size();
    }

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        String vowels = "aioue";

        for (int i = left; i <= right ; i++) {
            if (vowels.indexOf(words[i].charAt(0)) > -1 && vowels.indexOf(words[i].charAt(words[i].length() - 1)) > -1)
                count ++;
        }

        return count;
    }

    public List<String> cellsInRange(String s) {
        char startCh = s.charAt(0), endCh = s.charAt(3);
        int startI = s.charAt(1), endI = s.charAt(4);
        List<String> ls = new ArrayList<>();
        for (int i = startCh; i < endCh; i++) {
            for (int j = startI; j <endI ; j++) {
                ls.add(((char) i) + "" + j);
            }
        }

        return ls;
    }

    public static boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        String t;

        for (int i = 0; i < s.length(); i++) {
            t = Integer.toBinaryString(s.charAt(i));
            int x = 8 - t.length();
            System.out.println(t);
            while (x > 0) {
                sb.append('0');
                x --;
            }
            sb.append(t);
        }

        System.out.printf(sb.toString());
        return sb.toString().contentEquals(sb.reverse());
    }

    public String getSmallestString(String s) {
        int k, p;
        char[] mass = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            k = s.charAt(i) - '0';
            p = s.charAt(i + 1) - '0';
            if ((p - k) % 2 == 0) {
                mass[i] = s.charAt(i + 1);
                mass[i + 1] = s.charAt(i);
                return new String(mass);
            }
        }

        return s;
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        int[] arr = new int[26];
        int index;

        for (int i = s.length() - 1; i >= 0 ; i--) {
            index = s.charAt(i) - 'a';
            if (arr[index] == 0) arr[index] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            if (arr[index] > 0) {
                max = Math.max(max, arr[index] - i - 1);
            }
        }

        return max;
    }
}


