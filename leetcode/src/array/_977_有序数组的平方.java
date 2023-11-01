import java.util.Arrays;

/**
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 */


public class _977_有序数组的平方 {
    /**
     * 暴力揭发->每个数遍历平方之后再排序
     * 时间复杂度 O(n + nlogn)->O(nlogn)
     * 循环遍历 nums 数组并计算平方->时间复杂度 O(n)
     * 使用 Arrays.sort() 方法对 nums 数组进行排序->时间复杂度O(n logn)
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 相向指针法
     * 时间复杂度 O(n + nlogn)->O(nlogn)
     * @param nums
     * @return
     */
    public int[] sortedSquares1(int[] nums) {
        int index = nums.length - 1;//新数组的下标索引->因为数组平方后的值肯定是中间最小,两边最大
        int[] result = new int[nums.length];//开辟一个新整数数组
        for (int left = 0, right = nums.length - 1; left <= right ; ) {// 注意这里要i <= j，因为最后要处理两个元素
            if (nums[left] * nums[left] < nums[right] * nums[right]){
                result[index--] = nums[right] * nums[right];// result[k] == nums[j] * nums[j]; k--; ->合并
                right--;//右指针向左移动一位
            }
            else {//(nums[i] * nums[i] >= nums[j] * nums[j]
                result[index--] = nums[left] * nums[left];
                right++;//左指针向右移动一位
            }
        }
        return result;
    }
}
