/**
 * You are given two integer arrays nums1 and nums2.
 * We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.
 * We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:
 *
 ***** nums1[i] == nums2[j], and
 ***** the line we draw does not intersect any other connecting (non-horizontal) line.
 *
 */

package uncrossed.lines;

public class UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) {
            return 0;
        }

        if (nums1.length == 1 && nums2.length == 1) {
            if (nums1[0] == nums2[0]) {
                return 1;
            } else {
                return 0;
            }
        }

        int[][] memo = new int[nums1.length + 1][nums2.length + 1];

        maxUncrossedLines(nums1, nums2, 1,1, memo);
        return memo[nums1.length] [nums2.length];
    }

    public void maxUncrossedLines(int[] nums1, int[] nums2, int i, int j, int [][] memo) {
        if(i > nums1.length || j > nums2.length) {
            return;
        }

        if(nums1[i-1] == nums2[j-1]) {
            memo[i][j] = memo[i-1][j-1] + 1;
        } else {
            memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
        }

        if(j+1 < memo[0].length) {
            maxUncrossedLines(nums1, nums2, i, j+1, memo);
        } else {
            maxUncrossedLines(nums1, nums2, i+1, 1, memo);
        }
    }
}
