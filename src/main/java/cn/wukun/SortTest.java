package cn.wukun;

/**
 * 排序算法练习
 */
public class SortTest {
    public static void main(String[] args){
        //冒泡排序测试
        int[] nums = {1,3,5,7,2,4,8,6};
        bubble(nums);
        for(int num:nums){
            System.out.print(num + " ");
        }
        System.out.println();

        //插入排序测试
        int[] nums2 = {1,3,5,7,2,4,8,6};
        insert(nums2);
        for(int num:nums2){
            System.out.print(num + " ");
        }
        System.out.println();

        //选择排序测试
        int[] nums3 = {10,1,3,5,7,2,4,8,6};
        select(nums3);
        for(int num:nums3){
            System.out.print(num + " ");
        }
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
}
