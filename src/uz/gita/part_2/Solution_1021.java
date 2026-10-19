package uz.gita.part_2;

import java.util.Objects;
import java.util.Stack;

public class Solution_1021 {

    public static void main(String[] args) {

    }


    public int evalRPN(String[] tokens) {
        int x = 0, y = 0;
        Stack<Integer> stack = new Stack<>();
        for(String st: tokens) {
            switch (st) {
                case "+" : {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y + x);
                    break;
                }
                case "-" : {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y - x);
                    break;
                }
                case "*" : {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y * x);
                    break;
                }
                case "/" : {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y / x);
                    break;
                }
                default: {
                    stack.add(Integer.parseInt(st));
                }
            }
        }

        return stack.peek();
    }

    public String rearrangeString(String s, char x, char y) {
        if (s.indexOf(x) == -1 || s.indexOf(y) == -1) return s;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbX = new StringBuilder();
        StringBuilder sbY = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) sbX.append(x);
            else if (s.charAt(i) == y) sbY.append(y);
            else sb.append(s.charAt(i));
        }

        sbX.append(sb).append(sbY);
        return sbX.toString();
    }

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return isWhite(coordinate1) == isWhite(coordinate2);
    }

    private boolean isWhite(String x) {
        return ((x.charAt(0) - 'a' + 1) + (x.charAt(1) - '0')) % 2 == 0;
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int startIndex = -1, endIndex = -1, count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (startIndex == -1) startIndex = i;
            } else {
                count--;
                endIndex = i;
            }

            if (count == 0) {
                if (endIndex - startIndex > 1) sb.append(s, startIndex + 1, endIndex);
                startIndex = -1;
                endIndex = -1;
            }

            System.out.println("sb = " + sb);
        }

        return sb.toString();
    }
}
