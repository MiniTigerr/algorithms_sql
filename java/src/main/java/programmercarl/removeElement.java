package programmercarl;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Hezal
 * @Date: 2023/06/01/21:08
 * @Description:给定一个数组nums和一个目标值val，原地移除(即空间复杂度为O(1))数值等于val的元素，返回移除后数组的新长度
 */
public class removeElement {
    // 暴力解：第一层遍历数组；第二层删除数据后的更新数组
    // 时间复杂度O(n^2)
    public static int removeElement1(int[] nums, int val) {
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            if(nums[i] == val){
                for(int j = i+1; j < length; j++){
                    nums[j-1]=nums[j];
                }
                i--;
                length--;
            }
        }
        return length;
    }

    // 双指针法（快慢指针法）： 通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
    /*定义快慢指针
    快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
    慢指针：指向更新 新数组下标的位置
     */
    // 时间复杂度：O(n)  空间复杂度：O(1)
    public static int removeElement2(int[] nums, int val) {
        int slowIndex=0, fastIndex;
        for(fastIndex=0;fastIndex<nums.length;fastIndex++){
            if(nums[fastIndex]!=val){
                nums[slowIndex++]=nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
