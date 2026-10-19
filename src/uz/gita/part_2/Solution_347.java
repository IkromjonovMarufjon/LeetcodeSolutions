package uz.gita.part_2;

import java.util.*;
import java.util.function.BiConsumer;

public class Solution_347 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(2,2);
        map.put(1,3);
        map.put(3,1);
        map.put(4,1);
        map.put(5,2);
        map.put(6,1);

        System.out.println(xSum(map, 1));    // [1, 3]
        System.out.println(xSum(map, 2));    // [1, 3] [5, 2]
        System.out.println(xSum(map, 3));
        System.out.println(xSum(map, 4));
        System.out.println(xSum(map, 15));
    }

    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums.length - k + 1];
        int rp = 0;

        for (int i = 0; i < nums.length - k; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                }
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if (map.getOrDefault(nums[i], 0) == 0) map.remove(nums[i]);
                int index = i + k - 1;
                map.put(nums[index], map.getOrDefault(index, 0) + 1);
            }

            result[rp ++] = xSum(map, x);
        }

        return result;
    }

    private static int xSum(Map<Integer, Integer> map, int x) {
        List<Integer> ls = new ArrayList<>();
        map.forEach((key, value) -> {
            ls.add(value * 100_000 + key);
        });

        System.out.println(ls);
        Collections.sort(ls);
        System.out.println(ls);
        int[] sum = {0};
        map.forEach((key, value) -> {
            if (ls.indexOf(value * 100_000 + key) > ls.size() - x - 1)
                sum[0] += key * value;
        });

        return sum[0];
    }

    public int maximumStrongPairXor(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                    max = Math.max(max, nums[i] ^ nums[j]);
                }
            }
        }
        return max;
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = nums.length - k - 1; i < copy.length; i++) {
            ls.add(copy[i]);
        }

        int[] result = new int[k];
        int index = 0;
        for (int num : nums) {
            if (ls.contains(num)) {
                result[index++] = num;
                ls.remove(Integer.valueOf(num));
            }
        }


        return result;
    }

    private boolean isHas(int[] copy, int k, int amount) {
        int left = copy.length - k, right = copy.length;
        int middle;

        while (left <= right) {
            middle = (left + right)/2;
            if (copy[middle] == amount) {
                copy[middle] = Integer.MIN_VALUE;
                return true;
            }
            if (copy[middle] < amount) {
                left = middle + 1;
            } else right = middle - 1;
        }

        return false;
    }

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : deck)
            map.put(i, map.getOrDefault(i, 0) + 1);

        int[] arr = {-1};
        map.values().forEach(integer -> {
            if (arr[0] == -1) arr[0] = integer;
            else arr[0] = gcm(arr[0], integer);
        });
        return arr[0] != 1;
    }

    private static int gcm(int x, int y) {
        if (x == 0) return y;
        if (y == 0) return x;
        if (x == y) return x;
        if (x == 1 || y == 1) return 1;
        if (x > y) return gcm(x % y, y);
        else return gcm(x, y % x);
    }

    public int winningPlayerCount(int n, int[][] pick) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] arr: pick) {
                if (arr[0] == i)
                    map.put(arr[1], map.getOrDefault(arr[i], 0) + 1);
            }

            int x = i + 1;
            boolean[] bool = {false};

            map.forEach((key, value) -> {
                if (x == value) bool[0] = true;
            });

            if (bool[0]) count ++;
        }

        return count;
    }

    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;

        int size = n + 1;
        int[] counts = new int[size], temp = new int[size];

        for (int[] arr : trust) {
            counts[arr[0]] ++;
            temp[arr[1]] ++;
        }

        for (int i = 0; i < size; i++) {
            if (counts[i] == 0 && temp[i] == n - 1)
                return i;
        }

        return -1;
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int[] mass: pieces) {
            if (!temp(arr, mass)) return false;
        }

        return true;
    }

    private boolean temp(int[] arr, int[] temp) {
        int index = -1;
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] == temp[0]) {
                index = i;
                i = arr.length;
            }
        }

        if (index == -1) return false;
        for (int j : temp) {
            if (index < arr.length && arr[index] == j) {
                arr[index] = -1;
                index++;
            } else return false;
        }

        return true;
    }

    public int unequalTriplets(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j <nums.length - 1 ; j++) {
                if (nums[i] == nums[j]) continue;
                for (int k = j + 1; k <nums.length ; k++) {
                    if (nums[i] != nums[k])
                        count ++;
                }
            }
        }

        return count;
    }

    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums1)
            set.add(i);

        int min = Integer.MAX_VALUE;
        for (int j :nums2){
            if (set.contains(j))
                min = Math.min(min, j);
        }
        if (min != Integer.MAX_VALUE) return min;

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int i :nums1)
            min1 = Math.min(min1, i);

        for(int j :nums2)
            min2 = Math.min(min2, j);

        if (min1 <= min2) return min1 * 10 + min2;
        else return min2 * 10 + min1;
    }

    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = nums.size() - 1; i > 0; i --) {
            if (nums.get(i) <= k)
                set.add(nums.get(i));

            if (set.size() == k) return nums.size() - i - 1;
        }

        return -1;
    }

    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 2) != s.charAt(i + 1))
                count ++;
        }

        return count;
    }

    public int maxDepth(String s) {
        int count = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count ++;
            if (s.charAt(i) == ')') count --;
            max = Math.max(max, count);
        }

        return max;
    }

    public int minSteps(String s, String t) {
        int[] mass = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mass[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            mass[t.charAt(i) - 'a'] --;
        }
        int sum = 0;
        for (int i : mass) {
            if (i > 0) sum += i;
        }

        return sum;
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> ls = new ArrayList<>();
        int[] letters = new int[26];
        for (int i = s.length() - 1; i >= 0 ; i--) {
            int index = s.charAt(i) - 'a';
            if (letters[index] == 0)
                letters[index] = i;
        }

        int target = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == i) {
                ls.add(1);
                continue;
            }
            target = letters[s.charAt(i) - 'a'];
            if (target == s.length() - 1) {
                ls.add(s.length() - i + 1);
                continue;
            }

            for (int j = i; j < target; j++) {
                target = Math.max(target, letters[s.charAt(j) - 'a']);
            }
            ls.add(target - i + 1);
            i = target;
        }

        return ls;
    }
}
