package cn.wukun;

import java.util.Arrays;

/**
 * 排序算法练习
 */
public class SortTest {
    public static void main(String[] args){
        //冒泡排序测试
        int[] nums = {1,3,5,7,2,4,8,6};
        bubble(nums);
        System.out.println(Arrays.toString(nums));

        //插入排序测试
        int[] nums2 = {1,3,5,7,2,4,8,6};
        insert(nums2);
        System.out.println(Arrays.toString(nums2));

        //选择排序测试
        int[] nums3 = {10,1,3,5,7,2,4,8,6};
        select(nums3);
        System.out.println(Arrays.toString(nums3));

        //归并排序测试
        int[] nums4 = {10,1,3,5,7,2,4,8,6};
        merger(nums4);
        System.out.println(Arrays.toString(nums4));

        //快速排序测试
        int[] nums5 = {10,1,3,11,5,9,7,13,2,4,6,8};
        int[] temp = new int[nums5.length];
        quick(nums5, 0, nums5.length - 1, temp);
        System.out.println(Arrays.toString(nums5));
    }

    /**
     *  冒泡排序：
     *  只会操作相邻的两个元素，每次冒泡操作都会对相邻的两个元素比较，看是否满足大小关系要求。
     *  如果不满足就让他两互换。一次冒泡会至少让一个元素移动到它应该在的位置，
     *  重复n次，就完成了n个数据的排序工作。当某次冒泡已经没有数据交换时，说明已经达到完全有序。
     */
    public static void bubble(int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            boolean isMove = false; //遍历是否交换过元素位置

            for(int k = 0; k < nums.length - i - 1; k++){
                count++;

                if(nums[k] > nums[k+1]){
                    int index = nums[k];
                    nums[k] = nums[k+1];
                    nums[k+1] = index;

                    isMove = true;
                }
            }

            //若当前遍历未曾交换过元素的位置，则表示数组已排序完成
            if(!isMove){
                System.out.println("冒泡排序共比较了"+count+"才得到结果");
                return;
            }
        }

        System.out.println("冒泡排序共比较了"+count+"才得到结果");
    }

    /**
     * 插入排序：
     * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。
     * 初始已排序区间只有一个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，
     * 并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空。
     */
    public static void insert(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int index = nums[i];
            for(int k = i - 1; k >= 0; k--){
                if(nums[k] > index){
                    nums[k+1] = nums[k];
                    continue;
                }

                nums[k+1] = index;
                break;
            }
        }
    }

    /**
     * 选择排序：
     * 实现思路有点类似于插入排序，也分已排序区间和未排序区间。
     * 但是选择排序每次会从末尾排序区间中找到最小的元素，将其放到已排序的区间末尾。
     */
    public static void select(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int min = nums[i];
            int index = i;
            for(int k = i + 1; k < nums.length; k++){
                if(nums[k] < min){
                    min = nums[k];
                    index = k;
                }
            }
            nums[index] = nums[i];
            nums[i] = min;
        }
    }

    /**
     * 归并排序：
     * 归并排序的核心思想还是蛮简单的。如果要排序一个数组，我们先把数组从中间分成前后两部分
     * 然后对前后两部分分别进行排序，再将排好序的两部分合并在一起，这样整个数组就都有序了
     */
    public static void merger(int[] nums){
        int[] temp = new int[nums.length];
        mergerSort(nums, 0, nums.length-1, temp);
    }

    public static void mergerSort(int[] nums, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            mergerSort(nums, left, mid, temp);
            mergerSort(nums, mid+1, right, temp);
            merging(nums, left, mid, right, temp);
        }
    }

    /**
     * 快速排序：
     * 先选定数组中的一个元素
     * 将所有小于等于该元素的元素移动到该元素前面
     * 将所有大于该元素的元素移动到该元素后面
     * 排序过后的数组就分成了两部分
     * 再对这两部分进行同样的操作，直到所有元素排序完成即停止(left >= right)
     */
    public static void merging(int[] nums, int left, int mid, int right, int[] temp){
        int index1 = left;
        int index2 = mid + 1;
        int t = 0;
        while(index1 <= mid && index2 <= right){
            if(nums[index1] <= nums[index2]){
                temp[t++] = nums[index1++];
            }else{
                temp[t++] = nums[index2++];
            }
        }

        while(index1 <= mid){
            temp[t++] = nums[index1++];
        }

        while(index2 <= right){
            temp[t++] = nums[index2++];
        }

        //将临时数组temp中数据复制到nums中去
        t = 0;
        while(left <= right){
            nums[left++] = temp[t++];
        }
    }

    public static void quick(int[] nums, int left, int right, int[] temp){
        if(left < right) {
            int point = (left + right) / 2;
            point = quickSort(nums, left, right, point, temp);
            quick(nums, left, point, temp);
            quick(nums, point+1, right, temp);
        }
    }

    public static int quickSort(int[] nums, int left, int right, int point, int[] temp){
        int start = left;
        int end = right;
        for(int i = left; i <= right; i++){
            if(point == i){
                continue;
            }

            if(nums[i] <= nums[point]){
                temp[start++] = nums[i];
            }else{
                temp[end--] = nums[i];
            }
        }

        temp[start] = nums[point];

        start = left;
        while(left <= right){
            nums[left++] = temp[start++];
        }

        return end;
    }
}
