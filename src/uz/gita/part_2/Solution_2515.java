package uz.gita.part_2;

public class Solution_2515 {

    public static void main(String[] args) {
//        System.out.println(closestTarget(new String[]{"a", "b", "c", "d", "f", "g", "h", "j", "k", "l"}, "d", 0));
//        System.out.println(closestTarget(new String[]{"a", "b", "c", "a", "f", "g", "h", "j", "k", "l"}, "a", 0));
//        System.out.println(closestTarget(new String[]{"a", "b", "c", "a", "f", "g", "h", "j", "k", "l"}, "a", 1));
        System.out.println(closestTarget(new String[]{"a", "b", "c", "a", "f", "g", "h", "j", "f", "c"}, "a", 2));
        System.out.println(closestTarget(new String[]{"a", "b", "c", "a", "f", "g", "h", "j", "f", "c"}, "a", 8));
        System.out.println(closestTarget(new String[]{"a", "b", "c", "a", "f", "g", "h", "j", "f", "c"}, "a", 9));
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char searchCh = keysPressed.charAt(0);
        int min = releaseTimes[0];

        for (int i = 1; i < releaseTimes.length; i++) {
            if (min < releaseTimes[i] - releaseTimes[i - 1]) {
                min = releaseTimes[i] - releaseTimes[i - 1];
                searchCh = keysPressed.charAt(i);
            }

            if (min == releaseTimes[i] - releaseTimes[i - 1] && searchCh < keysPressed.charAt(i)) {
                searchCh = keysPressed.charAt(i);
            }
        }

        return searchCh;
    }


    public static int closestTarget(String[] words, String target, int startIndex) {
        int iR = -1, iL = -1;
        for (int i = startIndex; i < words.length; i++) {
            if (words[i].equals(target)) {
                iR = i;
                i = words.length;
            }
        }

        for (int i = startIndex; i >= 0; i --) {
            if (words[i].equals(target)) {
                iL = i;
                i = -1;
            }
        }

        if (iL == startIndex) return 0;
        if (iL != -1 && iR != -1) return Math.min(startIndex - iL, iR - startIndex);
        if (iL == -1 && iR == -1) return -1;

        if (iL != -1) {
            int t = 0;
            for (int i = 0; i < startIndex; i++) {
                if (words[i].equals(target)) {
                    t = i;
                    i = startIndex;
                }
            }

            return Math.min(startIndex - iL, words.length - startIndex + t);
        } else {
            int t = 0;
            for (int i = words.length - 1; i >= startIndex; i--) {
                if (words[i].equals(target)) {
                    t = words.length - i;
                    i = 0;
                }
            }

            return Math.min(startIndex + t, iR - startIndex);
        }
    }
}
