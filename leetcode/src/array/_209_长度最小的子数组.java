/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 */
public class _209_长度最小的子数组 {

    /**
     * 暴力解法->双循环嵌套
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE; //常量->表示整型变量的最大值->具体的值为 2^31 - 1，即 2147483647
        int sum = 0;//子序列的数值之和
        int subLength = 0;//子序列的长度
        for (int i = 0; i < nums.length; i++) {//设置子序列起点为i
            sum = 0;//在计算新的子序列之前，需要将 sum 的初始值设为 0，以确保每个子序列的求和从零开始
            for (int j = i; j < nums.length ; j++) {//设置子序列终止位置为j
                sum += nums[j];
                if (sum >= target){//一旦发现子序列和超过了target,更新result
                    subLength = j - i + 1;//取子序列的长度
                    result = Math.min(result, subLength);
                    break; //因为我们是找符合条件最短的子序列,j指向的是子序列的终止位置,j指针向右移->所以长度只会越来越长->所以一旦符合条件就break
                }
            }
        }
        //如果result 没有被赋值的话,就返回0,说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    /**
     * 滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。
     * 只用一个for循环，那么这个循环的索引，一定是表示 滑动窗口的终止位置
     * 滑动窗口解法 -> 用一个for循环来解决问题 ->for循环里面的j指向终止位置
     * 滑动窗口的关键 -> 双指针指向起始位置的指针如何移动
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0; //滑动窗口数值之和
        int i = 0; //滑动窗口起始位置
        int subLength = 0; //滑动窗口的长度
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            //注意这里使用while,每次更新i(起始位置),并不断比较子序列是否符合条件
            while (sum >= target){
                subLength = (j - i + 1);//取子序列的长度
                result = Math.min(result,subLength);
                // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置)->起始位置指针i向右移动
                sum -= nums[i++];
            }
        }
        //如果result 没有被赋值的话,就返回0,说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
