package uz.gita.part_2;

import java.util.Arrays;
import java.util.Stack;

public class Solution_3898 {

    public static void main(String[] args) {
//        System.out.println(isPerfectSquare(100));
//        System.out.println(isPerfectSquare(121));
//        System.out.println(isPerfectSquare(625));
//        System.out.println(isPerfectSquare(624));
//        System.out.println(isPerfectSquare(623));
//        System.out.println(isPerfectSquare(10_000));
//        System.out.println(isPerfectSquare(10_001));
//        System.out.println(isPerfectSquare(9_999));
        System.out.println(isPerfectSquare(2147483647));
        System.out.println(isPerfectSquare(2147395600));
        System.out.println(Math.sqrt(2147395600));
    }


    public static boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        int middle, x;
        if (right > 46341) right = 46341;

        while (left < right) {
            middle = (left + right) / 2;
//            System.out.println(middle);
            x = middle * middle;
            if (x == num) return true;
            if (x < num) left = middle + 1;
            else right = middle;
        }

        return false;
    }

    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int sum = n * n * 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 < 0) sum += grid[i][j];
                else if (grid[i][j] > grid[i + 1][j]) sum += (grid[i][j] - grid[i + 1][j]);

                if (j - 1 < 0) sum += grid[i][j];
                else if(grid[i][j] > grid[i][j -1]) sum += (grid[i][j] - grid[i][j -1]);

                if (i + 1 == n) sum += grid[i][j];
                else if (grid[i][j] > grid[i + 1][j]) sum += (grid[i][j] - grid[i + 1][j]);

                if (j + 1 == n) sum += grid[i][j];
                else if (grid[i][j] > grid[i][j + 1]) sum += (grid[i][j] - grid[i][j + 1]);
            }
        }

        return sum;
    }

    public static String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean x = num < 0;
        if (num < 0) num *= -1;

        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (x) return "-" + sb.reverse();
        else return sb.reverse().toString();
    }

    public String findLatestTime(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.charAt(0) == '?') {
            if (s.charAt(1) == '?' || s.charAt(1) == '1') sb.append(1);
            else sb.append(0);
        } else sb.append(s.charAt(0));
        if (s.charAt(1) == '?') {
            if (sb.charAt(0) == '0') sb.append(9);
            else sb.append(1);
        } else sb.append(s.charAt(0));
        sb.append(':');

        if (s.charAt(3) == '?') sb.append(5);
        else sb.append(s.charAt(3));
        if (s.charAt(4) == '?') sb.append(9);
        else sb.append(s.charAt(4));

        return sb.toString();
    }

    public int daysBetweenDates(String date1, String date2) {
        return calculateDays(date2) - calculateDays(date2);
    }

    private static int calculateDays(String date) {  // 1900-01-01
        int count = 0;
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));

        count += (year - 1900) * 365;
        for (int i = 1900; i < year; i+= 4) {
            if (isKabisaYear(i)) count ++;
        }

        int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            count += daysInMonth[i];
        }
        if (isKabisaYear(year) && month > 2) count ++;

        return count + day;
    }

    private static boolean isKabisaYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public int maxScore(String s) {
        int leftCount = 0;
        int rightCount = 0;
        if (s.charAt(0) == '0') leftCount ++;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') rightCount ++;
        }

        int max = leftCount + rightCount;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') leftCount ++;
            else rightCount --;
            max = Math.max(max, leftCount + rightCount);
        }

        return max;
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) stack.add(s.charAt(i));
            else {
                if (s.charAt(i) == '(') stack.add('(');
                if (stack.peek() == '(') stack.pop();
            }
        }

        return stack.size();
    }

    /*
    Characters ('a' to 'i') are represented by ('1' to '9') respectively.
    Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
    * */
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length()) {
                if (s.charAt(i + 2) == '#') {
                    sb.append((char) (Integer.parseInt(s.substring(i, i + 2)) + 'a'));
                    i += 2;
                } else sb.append((char)(s.charAt(i) - '0' + 'a'));
            } else sb.append((char)(s.charAt(i) - '0' + 'a'));

            System.out.println(sb);
        }

        return sb.toString();
    }

    public int countRotations(String s, int k) {
        int count = 0;

        StringBuilder sb = new StringBuilder(s);
        sb.append(s);

        for (int i = 0; i < sb.length()-1; i++) {
            int c = 0;
            for (int j = i + 1; j < i + s.length(); j++) {
                if (sb.charAt(j - 1) == sb.charAt(j)) c ++;
            }

            if (c == k) count ++;
        }
        return count;

    }

    public int countKConstraintSubstrings(String s, int k) {
        int count = 0;
        int zero = 0, one = 0, j = 0;

        for (int i = 0; i < s.length(); i++) {
            zero = 0;
            one = 0;
            j = i;
            while ((zero < k || one < k) && j < s.length()) {
                count ++;
                if (s.charAt(j) == '0') zero ++;
                else one ++;
                j ++;
            }
        }

        return count;
    }

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int arriveAliceDay = dayIndex(arriveAlice, arr);
        int leaveAliceDay = dayIndex(leaveAlice, arr);
        int arriveBobDay = dayIndex(arriveBob, arr);
        int leaveBobDay = dayIndex(leaveBob, arr);

        if (leaveAliceDay < arriveBobDay || leaveBobDay < arriveAliceDay) return 0;
        if (arriveAliceDay <= arriveBobDay && leaveBobDay <= leaveAliceDay) return leaveBobDay - arriveBobDay;
        if (arriveBobDay <= arriveAliceDay && leaveAliceDay <= leaveBobDay) return leaveAliceDay - arriveAliceDay;
        if (arriveAliceDay <= arriveBobDay) return leaveAliceDay - arriveBobDay;
        else return leaveBobDay - arriveAliceDay;
    }

    private static int dayIndex(String date, int[] arr) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));
        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += arr[i];
        }

        return sum + day;
    }

    public static boolean hasSpecialSubstring(String s, int k) {
        if (k == 1 && s.length() == 1) return true;
        if (k == 1 && s.length() == 2) {
            if (s.charAt(0) != s.charAt(1)) return true;
        }
        if (k == 1) {
            for (int i = 1; i < s.length() - 1; i++) {
                if (s.charAt(i - 1) != s.charAt(i) && s.charAt(i) != s.charAt(i + 1))
                    return true;
            }

            return s.charAt(0) != s.charAt(1) || s.charAt(s.length() - 2) != s.charAt(s.length() - 1);
        }


        int count = 0;
        int w = 0;
        for (int i = 1; i < s.length() - k; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                if (count == k - 1 && (w == 0 || s.charAt(w - 1) != s.charAt(w)))
                    return true;
                count = 0;
                w = i;
            }
        }
        System.out.println(count);
        return false;
    }

    public int minOperations(String s) {
        int start0 = 0;
        int start1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') start1++;
                else start0++;
            } else {
                if (s.charAt(i) == '1') start1++;
                else start0++;
            }
        }

        return Math.min(start0, start1);
    }

//    public static int countRotations(String s, int k) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(s);
//        sb.append(s);
//
//        int c = 0;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i - 1) == s.charAt(i)) c++;
//        }
//
//        int count = 0;
//        if (c == k) count++;
//
//        for (int i = 1; i < s.length(); i++) {
//            if (sb.charAt(i - 1) == sb.charAt(i)) c--;
//            if (sb.charAt(s.length() + i - 1) == sb.charAt(s.length())) c++;
//
//            if (c == k) count++;
//        }
//
//        return count;
//    }

    public String makeSmallestPalindrome(String s) {
        char[] mass = s.toCharArray();

        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) == s.charAt(s.length() - i - 1)) continue;
            else if (s.charAt(i) > s.charAt(s.length() - i - 1)) {
                mass[i] = s.charAt(s.length() - i - 1);
            } else {
                mass[s.length() - i - 1] = s.charAt(i);
            }
        }

        return new String(mass);
    }
}
