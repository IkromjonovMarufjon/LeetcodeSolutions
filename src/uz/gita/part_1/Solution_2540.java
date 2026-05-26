package uz.gita.part_1;

public class Solution_2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int result = -1;
        int i1 = 0, i2 = 0;

        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                result = nums2[i2];
                i1 = nums1.length;
                i2 = nums2.length;
            }

            else if (nums1[i1] > nums2[i2]) {
                i2 ++;
            }
            else if (nums1[i1] < nums2[i2]) {
                i1++;
            }
        }


        return result;
    }
}
