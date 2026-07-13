package uz.gita.part_1;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_2937 {

    public static void main(String[] args) {
        leftRightDifference(new int[] {10, 4, 8, 3});
    }

    public int splitNum(int num) {
        ArrayList<Integer> ls = new ArrayList<>();
        while (num > 0) {
            ls.add(num % 10);
            num /= 10;
        }
        Collections.sort(ls);
        int x = 0;
        int y = 0;
        for (int i = 0; i < ls.size() / 2; i++) {
            x = x * 10 + ls.get(i);
            y = y * 10 + ls.get(i + 1);
        }

        if (ls.size() % 2 == 1)
            x = x * 10 + ls.get(ls.size() - 1);

        System.out.println(x);
        System.out.println(y);
        return x + y;
    }

    public static int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i] + nums[i - 1];
            rightSum[nums.length - 1 - i] = nums[nums.length - 1 - i] + nums[nums.length  - i];
        }

        System.out.println(Arrays.toString(leftSum));
        System.out.println(Arrays.toString(rightSum));

        return leftSum;
    }

    public int maxProductDifference(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if(min2 > nums[i]) {
                    min2 = nums[i];
            }

            if (max1 < nums[i]) {
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i]) {
                max2 = nums[i];
            }
        }

        return max1 * max2 - min1 * min2;
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) return false;
        }

        return true;
    }

    public int[] sortByBits(int[] arr) {
        int[] mass = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mass[i] = count1(arr[i]);
        }

        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (mass[j] < mass[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    temp = mass[i];
                    mass[i] = mass[j];
                    mass[j] = temp;
                }

                if (mass[j] == mass[i] && arr[j] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    private int count1(int x) {
        int count = 0;
        String s = Integer.toBinaryString(x);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count ++;
        }

        return count;
    }

    public int countPairs(List<Integer> nums, int target) {
        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target)
                    count ++;
            }
        }

        return count;
    }

    public int minimumCost(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if (min2 > nums[i]) {
                min2 = nums[i];
            }
        }

        return nums[0] + min1 + min2;
    }

    //  [1,3,4,5]

    public int maximizeExpressionOfThree(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }

        return max1 + max2 - min;
    }

    public int furthestDistanceFromOrigin(String moves) {
        String s1 = moves;
        String s2 = moves;
        s1 = s1.replace('_', 'L');
        s2 = s2.replace('_', 'R');

        int max = 0;
        int countL = 0;
        int countR = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (s1.charAt(i) == 'L') countL ++;
            else max = Math.max(max, countL);

            if (s2.charAt(i) == 'R') countR ++;
            else max = Math.max(max, countR);
        }

        max = Math.max(max, countL);
        max = Math.max(max, countR);

        return max;
    }

    public int findMinimumOperations(String s1, String s2, String s3) {
        int count = 0;
        int min = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i))
                count ++;
            else i = Integer.MAX_VALUE;
        }

        if (count == 0) return -1;
        return s1.length() + s2.length() + s3.length() - 3 * count;
    }

    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) return false;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i))
                return false;
        }
        return true;
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return calc(firstWord) + calc(secondWord) == calc(targetWord);
    }

    private int calc(String s) {
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            x = 10 * x + (s.charAt(i) - 'a');
        }

        return x;
    }

    public int numberOfSpecialChars(String word) {
        int[] lowers = new int[26];
        int[] uppers = new int[26];
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a')
                lowers[word.charAt(i) - 'a'] ++;
            else uppers[word.charAt(i) - 'A'] ++;
        }

        for (int i = 0; i < 26; i++) {
            if (lowers[i] > 0 && uppers[i] > 0)
                count ++;
        }

        return count;
    }

    public boolean hasMatch(String s, String p) {
        int i = p.indexOf("*");
        String start = p.substring(0, i);
        String end = p.substring(i+1);

        int k = s.indexOf(start);
        if (k == -1) return false;
        if (end.isEmpty()) return true;

        int m = s.indexOf(end, k + start.length());

        return m != -1;
    }

    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)))
                sb.append(s.charAt(i));

            if (s.charAt(i) == '*' && sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);

            if (s.charAt(i) == '#') sb.append(sb);

            if (s.charAt(i) == '%')  sb.reverse();
        }

        return sb.toString();
    }
}
