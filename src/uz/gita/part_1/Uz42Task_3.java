package uz.gita.part_1;

public class Uz42Task_3 {

    public static void main(String[] args) {
//        System.out.println(isValidSubsequence(new int[]{2,5,9,6}, new int[]{-1,2,58,8,5,2,6,9}));
//        System.out.println(isValidSubsequence(new int[]{2,5,9,6}, new int[]{-1,2,58,8,5,2,6,9,3,6,3}));
//        System.out.println(isValidSubsequence(new int[]{2,5,9,6}, new int[]{-1,2,58,8,5,2,6,9,3,6}));
//        System.out.println(isValidSubsequence(new int[]{2,5,9,6}, new int[]{-1,2,58,8,5,2,6}));
//        System.out.println(isValidSubsequence(new int[]{2,5,9,6}, new int[]{-1,2,58,8,5,2}));
//        System.out.println(isValidSubsequence(new int[]{2,5,9,6}, new int[]{-1,2,58,8}));
//        System.out.println(isValidSubsequence(new int[]{2,5,9,6}, new int[]{2,5,9,6}));
//        System.out.println(isValidSubsequence(new int[]{2}, new int[]{2,5,9,6}));
//        System.out.println(isValidSubsequence(new int[]{6}, new int[]{2,5,9,6}));
//        System.out.println(isValidSubsequence(new int[]{60}, new int[]{2,5,9,6}));
        System.out.println(isValidSubsequence(new int[]{4, 5, 1, 22, 25, 6, -1, 8, 10}, new int[]{5, 1, 22, 25, 6, -1, 8, 10}));
    }

    public static boolean isValidSubsequence(int[] array, int[] sequence) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length - i > sequence.length - index) return false;
            boolean isFind = false;
            for (int j = index; j <sequence.length ; j++) {
                if (array[i] == sequence[j]) {
                    index = j + 1;
                    j = sequence.length;
                    isFind = true;
                }
            }

            if (!isFind) return false;
        }

        return true;
    }
}
