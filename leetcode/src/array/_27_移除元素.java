/**
 * https://leetcode.cn/problems/remove-element/
 */
public class _27_移除元素 {
    /**
     * 数组的元素在内存地址中是连续的，不能单独删除数组中的某个元素，只能覆盖。
     * @param nums
     * @param val
     * @return
     */

    /* 暴力解法
     * 时间复杂度 O(n2)->两个for循环嵌套
     * 空间复杂度 O(1)
     */
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {//遍历
            if (nums[i] == val){//发现需要移除的元素,就将数组集体向前移动一位->覆盖
                for (int j = i + 1; j < size ; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;//因为下标i以后的数值都向前移动了一位,所以i也要向前移动一位
                size--;//此时数组的大小-1
            }
        }
        return size;
    }

    /* 快慢指针解法
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int removeElement1(int[] nums, int val) {
       int slowIndex = 0;//->新数组的索引
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {//原数组索引
            if (nums[fastIndex] != val){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    /* 相向指针解法->基于元素顺序可以改变的题目条件改变了元素的相对位置,确保了移动最少元素
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        // 如果左指针left 指向的元素等于 val，
        // 此时将右指针 right 指向的元素复制到左指针 left 的位置，
        // 然后右指针 right 左移一位。
        //如果赋值过来的元素恰好也等于 val
        // 可以继续把右指针 right指向的元素的值赋值过来（左指针 left指向的等于 val的元素的位置继续被覆盖），
        // 直到左指针指向的元素的值不等于 val 为止。
        //当左指针 left和右指针 right重合的时候，左右指针遍历完数组中所有的元素。

        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;

    }
}
