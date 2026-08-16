package leetcode.T209;

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
// nums == null
// nums is empty (zero elements)

public class T209 {
    public int minSubArrayLen(int target, int[] nums) {
        int begin = 0;
        int window_state = 0;
        int result = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            window_state += nums[end];

            //end = 2 -> true
            while (window_state >= target) {
                result = Math.min(result, end - begin + 1);
                window_state -= nums[begin];
                begin++;
            }
        }

        if (result == Integer.MAX_VALUE) {
            return 0;
        }

        return result;
    }
}
