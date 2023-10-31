/**
 * https://leetcode.cn/problems/binary-search/
 */

public class _704_二分查找 {
    /**
     *
     * 前提是数组为有序数组，同时题目还强调数组中无重复元素
     * 一旦有重复元素，使用二分查找法返回的元素下标可能不是唯一的
     * 时间复杂度 O(log n) ->n 是 nums 数组的长度
     * 空间复杂度 O(1)
     * @param nums
     * @param target
     * @return
     */

    /* 左闭右闭区间 */
    public int search(int[] nums, int target) {

        //避免当target < nums[0] || target > nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1])
            return -1;

        //索引赋值
        int left = 0;
        int right = nums.length - 1;//定义target在左闭右闭的区间里,[left,right]
        while (left <= right){//当left==right, 区间[left,right]依然有效,所以用<=
            int mid = left + (right - left) / 2;//防止溢出 等同于(left + right)/2
            if (nums[mid] == target)
                return mid;//数组中找到目标值,直接返回下标
            else if (nums[mid] < target)//target在右区间,所以[middle + 1,right]
                left = mid + 1;
            else if (nums[mid] > target)//target在左区间,所以[left,middle -1]
                right = mid - 1;
        }
        //未找到目标值
        return -1;
    }

    /* 左闭右开区间 */
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length;// 定义target在左闭右开的区间里，即：[left, right)
        while (left < right){ // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;// target 在右区间，在[middle + 1, right)中
            else if (nums[mid] > target)
                right = mid;// target 在左区间，在[left, middle)中

        }
        return  -1;
    }
}
