package uz.gita.part_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution_2027 {
    public static void main(String[] args) {
//        System.out.println(isPrefixOfWord("b bu bur burg burger", "burg"));
//        System.out.println(isPrefixOfWord("b bu bur burg burger", "burger"));
        System.out.println(worker2(-1));
        System.out.println(worker2(-2));
    }

    public boolean checkRecord(String s) {
        int aCount = 0;
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') aCount ++;
            if (s.charAt(i) == 'L') x ++;
            else x = 0;
            if (x > 3) return false;
        }

        return aCount < 2;
    }

    public String toHex(int num) {
        if (num >= 0) return worker1(num);
        else return worker2(num);
    }

    public String worker1(int num) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(0, '0');
        map.put(1, '1');
        map.put(2, '2');
        map.put(3, '3');
        map.put(4, '4');
        map.put(5, '5');
        map.put(6, '6');
        map.put(7, '7');
        map.put(8, '8');
        map.put(9, '9');
        map.put(10, 'a');
        map.put(11, 'b');
        map.put(12, 'c');
        map.put(13, 'd');
        map.put(14, 'e');
        map.put(15, 'f');

        StringBuilder st = new StringBuilder();
        while (num > 0) {
            st.append(map.get(num % 16));
            num /= 16;
        }

        return st.reverse().toString();
    }

    private static String worker2(int sum) {
        long sum2 = -1L * sum;
        StringBuilder sb = new StringBuilder(32);
        while (sum2 > 0) {
            sb.append(sum2 % 2);
            sum2 /= 2;
        }
        for (int i = sb.length(); i < 32; i++) {
            sb.append(0);
        }
        for (int i = 0; i < 32; i++) {
            if (sb.charAt(i) == '0') sb.setCharAt(i, '1');
            else sb.setCharAt(i, '0');
        }
        StringBuilder x = sb.reverse();
        int amount = 1;
        int index = sb.length() - 1;
        while (index >=0 && amount == 1) {
            amount = (x.charAt(index) - '0') + amount;
            if (amount == 1) {
                x.setCharAt(index, '1');
                amount = 0;
            } else {
                amount = 1;
                x.setCharAt(index, '0');
                index --;
            }
        }

//        System.out.println(x);
        HashMap<String, Character> map = new HashMap<>();
        map.put("0000", '0');
        map.put("0001", '1');
        map.put("0010", '2');
        map.put("0011", '3');
        map.put("0100", '4');
        map.put("0101", '5');
        map.put("0110", '6');
        map.put("0111", '7');
        map.put("1000", '8');
        map.put("1001", '9');
        map.put("1010", 'a');
        map.put("1011", 'b');
        map.put("1100", 'c');
        map.put("1101", 'd');
        map.put("1110", 'e');
        map.put("1111", 'f');

        StringBuilder result = new StringBuilder(8);
        for (int i = 0; i < 32; i+=4) {
            result.append(map.get(x.substring(i, i + 4)));
        }
        return result.toString();
    }

    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        long result = 0;
        int k = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) result += nums[i];
            else result -= nums[i];
        }

        return result;
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        int count = 1;
        boolean bool = true, check = true;

        for (int i = 0; i < sentence.length(); i++) {
            if (bool) {
                bool = false;
                check = true;
                for (int j = 0; j < searchWord.length(); j++) {
                    if (sentence.charAt(i) == ' ') {
                        check = false;
                        j = searchWord.length();
                        continue;
                    }
                    if (i == sentence.length()) return -1;
                    if (sentence.charAt(i ++) != searchWord.charAt(j)) {
                        check = false;
                    }
                }
                if (check) return count;
            }
            if (sentence.charAt(i) == ' ') {
                bool = true;
                count ++;
            }
        }

        return count;
    }

    public int furthestDistanceFromOrigin(String moves) {
        int x = 0;
        int count = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == '_') x ++;
            else if (moves.charAt(i) == 'L') count --;
            else count ++;
        }

        return Math.abs(count) + x;
    }

    public int minimumMoves(String s) {
        int count = 0;
        int x = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') x ++;
            else if (x > 0) x ++;

            if (x == 3) {
                x = 0;
                count ++;
            }
        }

        if (x != 0) {
            count ++;
        }

        return count;
    }
}
