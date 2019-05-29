import java.util.Arrays;

/**
 * Created by wukun on 2019/5/28.
 */
public class Test {
    public static void main(String[] args){
        int[] nums = {1,3,5,7,2,4,6,8};
        int left = 0;
        int right = nums.length - 1;
        int mid = (left+right)/2;

        int[] temp = new int[nums.length];
        merging(nums, left, mid, right, temp);
        System.out.println(Arrays.toString(nums));
    }

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
        while(t < nums.length){
            nums[left++] = temp[t++];
        }
    }
}
