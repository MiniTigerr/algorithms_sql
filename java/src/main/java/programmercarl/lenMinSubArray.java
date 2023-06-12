package programmercarl;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Hezal
 * @Date: 2023/06/12/21:02
 * @Description:给定一个含有n个正整数的数组nums和一个正整数target，找出该数组中满足其和≥s的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回0
 */
public class lenMinSubArray {
    // Way1暴力解：第一层循环记录子序列起点，第二层循环记录子序列终点
    // 时间复杂度：O（n^2）  空间复杂度：O（1）
    public int lenMinSubArray1(int target, int[] nums) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++){
            int sum=0;
            for(int j = i; j < nums[i]; j++){
                sum+=nums[j];
                if(sum>=target){
                    int templength=j-i+1;
                    result = result<templength?result:templength;
                    break;
                }
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    // 滑动窗口法：一层for循环指向子序列终点，负责找>目标值的“第一个”位置，起点才开始挪，挪到小于目标值的“第一个”位置
    // 时间复杂度：O（n）里面不是还有个循环吗，咋就n了  空间复杂度：O（1）
    // 不要以为for里放一个while就以为是O(n^2)啊， 主要是看每一个元素被操作的次数，每个元素在滑动窗后进来操作一次，出去操作一次，
    // 每个元素都是被操作两次，所以时间复杂度是 2 × n 也就是O(n)
    public int lenMinSubArray2(int target, int[] nums) {
        int i=0,sum=0;
        int result=Integer.MAX_VALUE;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            while(sum>=target){
                int templength=j-i+1;
                result = result<templength?result:templength;
                sum-=nums[i++];
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
