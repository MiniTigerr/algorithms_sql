package programmercarl;

/**
 * Created with IntelliJ IDEA.
 * @Author: Hezal
 * @Date: 2023/05/26/21:27
 * @Description:二分查找。
 * 给定一个n个元素有序的（升序）整型数组nums和一个目标值target，如果目标值存在返回下标，否则返回-1
 * 前提:数组有序且无重复元素
 * 时间复杂度O（logn）  空间复杂度O（1）
 */
public class binarySearch_1 {
    // 1.左闭右闭区间
    public static int search1(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while (left <= right) {
            int middle = (left + right)/2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // 2.左闭右开区间
    public static int search2(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while (left < right) {
            int middle = (left + right)/2;
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // eg1、搜索插入位置。给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
    /*
        目标值插入的位置共有四种可能：
         （1）数组第一个元素的前面；
         （2）数组等于目标值的位置；
         （3）数组中的位置；
         （4）数组最后一个元素的后面
     */
    // way1: 暴力求解
    // 时间复杂度O（n）  空间复杂度O（1）
    public static int search3(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > target){return i;}  // （1）（2）（3）
        }
        return nums.length;  // （1）
    }
    // way2: 二分查找
    // 1.左闭右闭区间
    public static int search4(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while (left <= right) {
            int middle = (left + right)/2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;  // (2)
            }
        }
        return right+1;  // (1)(3)(4)
    }
    // 2.左闭右开区间
    public static int search5(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while (left < right) {
            int middle = (left + right)/2;
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return right;
    }

    // eg2、在排序数组中查找目标元素的第一个和最后一个位置。
    // 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    /*
        目标值在数组的左右边界分三种情况：
          (1)在数组的左边或者右边
          (2)在数组范围中，但是没有目标值
          (3)在数组范围中，并且有目标值
     */
    // 寻找右边界 找大于目标值的位置
    public static int rightBorder(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        int rightBorder = -2; // 如果rightBorder最后都没有被赋值，那目标值在数组左边
        while (left <= right) {
            int middle = (left + right)/2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else{
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
    // 寻找左边界
    public static int leftBorder(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        int leftBorder = -2; // 如果leftBorder最后都没有被赋值，那目标值在数组右边
        while (left <= right) {
            int middle = (left + right)/2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else{
                right = middle - 1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }
    public static int[] searchRange(int[] nums, int target){
        int leftBorder = leftBorder(nums, target);
        int rightBorder = rightBorder(nums, target);
        // (1)在数组的左边或者右边
        if(leftBorder == -2 || rightBorder == -2)return new int[]{-1,-1};
        // (3)在数组范围中，并且有目标值
        if(rightBorder-leftBorder > 1) return new int[]{leftBorder+1, rightBorder-1};
        return new int[]{-1,-1};
    }


    public static void main(String[] args) {
        int[] nums = new int[6];
        nums[0] = 3;
        nums[1] = 5;
        nums[2] = 6;
        nums[3] = 6;
        nums[4] = 9;
        nums[5] = 14;
        int index1 = search1(nums, 8);
        int index2 = search2(nums, 18);
        int index3 = search3(nums, 18);
        int index5 = search5(nums, 7);
        int[] index6 = searchRange(nums, 7);
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index5);
        for (int i = 0;i < index6.length;i++){
                System.out.println(index6[i]);
        }
    }
}
