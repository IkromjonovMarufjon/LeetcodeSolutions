//package uz.gita.part_1;
//
//import java.util.*;
//
//public class Solution_148 {
//
//    public static void main(String[] args) {
////        System.out.println(removeOuterParentheses("(()())"));
////        System.out.println(removeOuterParentheses("(())"));
////        System.out.println(removeOuterParentheses("()"));
////        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
//
//        minimumFlips(100);
//    }
//
//    public static int minimumFlips(int n) {
//        String s = Integer.toBinaryString(n);
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != s.charAt(s.length() - i - 1))
//                count ++;
//        }
//
//        return count;
//    }
//
//    public int residuePrefixes(String s) {
//        Set<Character> set = new HashSet<>();
//        int count = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            set.add(s.charAt(i));
//            if (set.size() == i % 3)
//                count ++;
//
//            if (set.size() == 4) i=s.length();
//        }
//
//        return count;
//    }
//
//
//    public int firstMatchingIndex(String s) {
//        int x = s.length() / 2 + s.length() % 2;
//
//        for (int i = 0; i < x; i++) {
//            if (s.charAt(i) == s.charAt(s.length() - i - 1))
//                return i;
//        }
//
//        return -1;
//    }
//
//    public int[] scoreValidator(String[] events) {
//        int score = 0;
//        int counter = 0;
//
//        for (int i = 0; i < events.length; i++) {
//            if (Objects.equals(events[i], "W"))
//                counter ++;
//            else if (Objects.equals(events[i], "WD") || Objects.equals(events[i], "NB")) {
//                score ++;
//            }
//            else {
//                score += Integer.parseInt(events[i]);
//            }
//
//            if (counter == 10)
//                i = events.length;
//        }
//
//        return  new int[] {score, counter};
//
//    }
//
//
//    public static String removeOuterParentheses(String s) {
//        Stack<Character> stack = new Stack<>();
//        int startIndex = 0;
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (stack.isEmpty())
//                stack.push(s.charAt(i));
//            else if (stack.lastElement() == '(' && s.charAt(i) == ')')
//                stack.pop();
//            else stack.push(s.charAt(i));
//
//            if (stack.isEmpty()) {
//                sb.append(s, startIndex + 1, i);
//                startIndex = i +1;
//            }
//        }
//
//        return sb.toString();
//    }
//
//    // (()())(())(()(())) ->  "(()())" + "(())" + "(()(()))" -> ()() + () + ()(())
//
//    public ListNode sortList(ListNode head) {
//        ArrayList<Integer> ls = new ArrayList<>();
//
//        while (head != null) {
//            ls.add(head.val);
//            head = head.next;
//        }
//
//        Collections.sort(ls);
//        ListNode result = new ListNode(ls.get(0));
//        ListNode temp = result;
//        ListNode x = null;
//
//        for (int i = 1; i < ls.size();  i++) {
//            x = new ListNode(ls.get(i));
//            temp.next = x;
//            temp = temp.next;
//        }
//
//        return result;
//    }
//}
//
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
