package uz.gita.part_2;

import java.util.ArrayList;
import java.util.List;

public class Solution_257 {

    public boolean checkOnesSegment(String s) {
        int index = s.indexOf('0');
        if (index == -1) return true;
        return s.lastIndexOf('1') < s.indexOf('0');
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int count0 = 0, count1 = 0;
        for (int group : groups) {
            if (group == 0) count0++;
            else count1++;
        }

        int i = 0;
        List<String> result = new ArrayList<>();
        boolean isSearch0 = groups[0] == 0;

        while (i < words.length) {
            if (isSearch0) {
                while (i < words.length && groups[i] == 1) {
                    i++;
                }
                if (i < words.length) {
                    result.add(words[i]);
                    isSearch0 = false;
                }
            } else {
                while (i < words.length && groups[i] == 0) {
                    i++;
                }
                if (i < words.length) {
                    result.add(words[i]);
                    isSearch0 = true;
                }
            }
        }

        return result;
    }

    public int maxRepeating(String sequence, String word) {
        if (!sequence.contains(word)) return 0;

        int count = 0, result = 0;
        int k = sequence.length() - word.length() + 1;

        for (int p = 0; p < k; p++) {
            for (int i = p; i < k; ) {
                boolean bool = true;
                for (int j = 0; j < word.length(); j++) {
                    if (sequence.charAt(i + j) != word.charAt(j)) {
                        bool = false;
                        j = word.length();
                    }
                }

                if (bool) {
                    count ++;
                    i += word.length();
                }
                else {
                    i ++;
                    result = Math.max(result, count);
                    count = 0;
                }
            }
            result = Math.max(result, count);
        }

        return Math.max(result, count);
    }

    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder(num);
        while (sum > 0 && sb.length() < num) {
            if (sum > 9) {
                sb.append(9);
                sum -= 9;
            } else {
                sb.append(sum);
                sum = 0;
            }
        }
        if (sum != 0) return "";

        for (int i = sb.length(); i < num; i++) {
            sb.append(0);
        }
        return sb.toString();
    }

    public int findTheLongestBalancedSubstring(String s) {
        List<Integer> ls0 = new ArrayList<>();
        List<Integer> ls1 = new ArrayList<>();
        char temp = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (temp == s.charAt(i)) count ++;
            else {
                if(temp == '0') ls0.add(count);
                else ls1.add(count);

                temp = s.charAt(i);
                count = 1;
            }
        }

        if(temp == '0') ls0.add(count);
        else ls1.add(count);
        if (s.charAt(0) == '1') ls1.remove(0);

        int result = 0;
        int minSize = Math.min(ls0.size(), ls1.size());
        for (int i = 0; i < minSize; i++) {
            result = Math.max(result, 2 * Math.min(ls0.get(i), ls1.get(i)));
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        worker(root, result, "");
        return result;
    }

    public void worker(TreeNode root, List<String> list, String st) {
        String x = null;
        if (st.isEmpty()) x = root.val + "";
        else   x = x + "->" + root.val;
        if (root.left != null) worker(root.left, list, x);
        if (root.right != null) worker(root.right, list, x);
        if (root.left == null && root.right == null) list.add(st);
    }
}

