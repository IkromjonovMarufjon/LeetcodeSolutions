package uz.gita.part_2;

import java.util.*;

public class Solution_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int j : arr) {
            if (j % 2 == 1) count++;
            else count = 0;

            if (count == 3) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] indices = new int[2][];
        indices[0] = new int[]{0,1};
        indices[1] = new int[]{1,1};
        oddCells(2,3, indices);
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                result.add(i);
        }

        return result;
    }

    public static int oddCells(int m, int n, int[][] indices) {
        int[][] temp = new int[m][n];   // indices[0]  -> row    indices[1]  -> column
        for (int i = 0; i < indices.length; i++) {
            // row
            for (int j = 0; j < m; j++) {
                temp[indices[i][0]][j] ++;
            }
            for (int j = 0; j < n; j++) {
                temp[j][indices[i][1]] ++;
            }
            showMatrix(temp);
        }

        int count = 0;
        for (int[] index : temp) {
            for (int i : index) {
                if ((i & 1) == 0) count++;
            }
        }
        return count;
    }

    private static void showMatrix(int[][] temp) {
        System.out.println("---------------------------------------------");
        for (int[] arr : temp) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("---------------------------------------------");
    }

    public static int evenNumberBitwiseORs(int[] nums) {
        int temp = 0, sum = 0;
        for (int num: nums) {
            temp = temp | num;
            if (temp % 2 == 0) {
                sum = temp;
                System.out.println(num);
            }
            else temp = sum;
        }

        return sum;
    }

    public int[] findDegrees(int[][] matrix) {
        int[] result = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[i][j];
            }
            result[i] = sum;
        }

        return result;
    }

    public int elevatorRequests(int n, int[] requests) {
        int result = requests[0];

        for (int i = 1; i < requests.length; i++) {
            result += (Math.abs(requests[i] - requests[i-1]));
        }

        return result;
    }

    public static int countValidSelections(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (worker(nums, i, true)) count ++;
                if (worker(nums, i, false)) count ++;
            }
        }

        return count;
    }

    private static boolean worker(int[] nums, int startIndex, boolean isRight) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        int i = startIndex;

        while (i >= 0 && i < temp.length) {
            System.out.println(Arrays.toString(temp));
            if (temp[i] != 0) {
                temp[i]--;
                isRight = !isRight;
            }
            if (isRight) i ++;
            else i --;
        }

        return checkEmpty(temp);
    }

    private static boolean checkEmpty(int[] temp) {
        for (int t: temp)
            if (t != 0) return false;

        return true;
    }


    public int sumCounts(List<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                set.add(nums.get(i));
            }
            sum += set.size() * set.size();
        }

        return sum;
    }

//    [-5,-2,4,4,-2]
    public int minStartValue(int[] nums) {   // 1 + -2 + -3
        int sum = 0;
        int temp = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] += temp;
                temp = 0;
                sum += nums[i];
                result = Math.min(sum, result);
            } else{
                temp += nums[i];
            }
        }

        if (result == 0) return 1;
        else return  -1* result + 1;
    }

    public static int[] decrypt(int[] code, int k) {
        if (k == 0) {
            return new int[code.length];
        }
        int border = code.length;
        int[] temp = new int[3 * border];
        for (int i = 0; i < border; i++) {
            temp[i] = code[i];
            temp[i + border] = code[i];
            temp[i + 2 * border] = code[i];
        }

        System.out.println(Arrays.toString(temp));
        int[] result = new int[border];
        if (k > 0) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += temp[border + i + 1];
            }
            result[0] = sum;

            for (int i = 1; i < border; i++) {
                result[i] = result[i - 1] + temp[border + i + k] - temp[border + i];
            }
        } else {
            int sum = 0;
            k *= -1;
            for (int i = 0; i < k; i++) {
                sum += temp[border - i - 1];
            }
            result[0] = sum;
            System.out.println("result [0] = " + sum);
            System.out.println("--------------------");

            for (int i = 1; i < border; i++) {
                System.out.println("New element = " + temp[border + i - 1]);
                System.out.println("Delete element = " + temp[border + i - k - 1]);
                result[i] = result[i - 1]  - temp[border + i - k - 1] + temp[border + i - 1];
                System.out.println("result[" + i + "] = " + result[i]);
                System.out.println("-------------------------------");
            }
        }
        return result;
    }

    public int lastStoneWeight(int[] stones) {   // length <= 30
        if (stones.length == 1) return stones[0];
        while (true) {
            Arrays.sort(stones);
            if (stones[stones.length - 1] == 0) return 0;
            if (stones[stones.length - 2] == 0) return stones[stones.length - 1];
            if (stones[stones.length - 2] == stones[stones.length - 1]) {
                stones[stones.length - 2] = 0;
                stones[stones.length - 1] = 0;
            } else {
                stones[stones.length - 1] -= stones[stones.length - 2];
                stones[stones.length - 2] = 0;
            }
        }
    }
}
