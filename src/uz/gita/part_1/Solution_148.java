package uz.gita.part_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution_148 {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())"));
        System.out.println(removeOuterParentheses("(())"));
        System.out.println(removeOuterParentheses("()"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int startIndex = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty())
                stack.push(s.charAt(i));
            else if (stack.lastElement() == '(' && s.charAt(i) == ')')
                stack.pop();
            else stack.push(s.charAt(i));

            if (stack.isEmpty()) {
                sb.append(s, startIndex + 1, i);
                startIndex = i +1;
            }
        }

        return sb.toString();
    }

    // (()())(())(()(())) ->  "(()())" + "(())" + "(()(()))" -> ()() + () + ()(())

    public ListNode sortList(ListNode head) {
        ArrayList<Integer> ls = new ArrayList<>();

        while (head != null) {
            ls.add(head.val);
            head = head.next;
        }

        Collections.sort(ls);
        ListNode result = new ListNode(ls.get(0));
        ListNode temp = result;
        ListNode x = null;

        for (int i = 1; i < ls.size();  i++) {
            x = new ListNode(ls.get(i));
            temp.next = x;
            temp = temp.next;
        }

        return result;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
