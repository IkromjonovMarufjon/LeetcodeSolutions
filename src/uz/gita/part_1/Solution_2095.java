package uz.gita.part_1;

import java.util.Arrays;

public class Solution_2095 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;

        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
                    count ++;

                if (dominoes[i][0] == dominoes[j]  [0] && dominoes[i][1] == dominoes[j][1])
                    count ++;
            }
        }

        return  count;
    }
    
    public ListNode deleteMiddle(ListNode head) {
        ListNode x = head;
        ListNode x2 = head;

        while (x2 != null) {
            if (x != null) x = x.next;

            x2 = x2.next;
            if (x2 != null) x2 = x2.next;
        }

        System.out.println(x.val);

        return head;
    }

    public int countCharacters(String[] words, String chars) {
        int[] mass = generateMass(chars);
        int sum = 0;

        for (int i = 0; i < words.length; i++) {
            int[] copy = Arrays.copyOf(mass, mass.length);
            for (int j = 0; j < words[i].length(); j++) {
                copy[words[i].charAt(j) - 'a'] --;
            }

            boolean bool = true;
            for (int j = 0; j < 26; j++) {
                bool &= copy[i] >= 0;
            }

            if (bool) sum += words[i].length();
        }

        return sum;
    }

    private int[] generateMass(String s) {
        int[] mass = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mass[s.charAt(i) - 'a'] ++;
        }

        return mass;
    }


    public int balancedStringSplit(String s) {
        int count = 0;
        int x = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') x ++;
            else x --;

            if (x == 0)
                count ++;
        }

        return count;
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public int[] diStringMatch(String s) {
        int[] mass = new int[s.length() + 1];

        int d = s.length();
        int i = 0;
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == 'I')
                mass[k] = i ++;
            else mass[k] = d --;
        }

        mass[s.length()] = d;

        return mass;
    }

    public int countKeyChanges(String s) {
        char ch = s.charAt(0);
        int count = 0;

        for (int i = 1; i <s.length(); i++) {
            if (Character.toLowerCase(ch) != Character.toLowerCase(s.charAt(i))) {
                count ++;
                ch = s.charAt(i);
            }
        }

        return count;
    }

    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0))
                    count ++;
            }
        }

        return count;
    }

    public int prefixCount(String[] words, String pref) {
        int count =0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(pref))
                count ++;
        }

        return count;
    }
}
