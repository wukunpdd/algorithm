# 递归算法
递归需要满足的三个条件
- 一个问题的解可以分解成几个子问题的解
- 这个问题与分解之后的子问题，除了数据规模不同，求解思路完全一样
- 存在递归终止条件

递归算法运用示例(https://github.com/wukunpdd/algorithm/blob/master/src/main/java/cn/wukun/RecursiveTest.java)
- 斐波那契数列(兔子数列)
- 汉诺塔问题

# 排序
如何分析一个排序算法：
1.算法的执行效率
- 最好、最好、平均情况时间复杂度
- 时间复杂度的系数、常数和低阶
- 比较次数、交换(移动)次数
2.排序算法的稳定性
- 如果待排序的序列中存在值相等的元素，经过排序之后，相等元素之间的前后顺序不变
- 可针对对象的多种属性进行优先级排序
3.排序算法的内存消耗，即空间复杂度

排序算法名称 | 空间复杂度 |  原地排序算法 | 稳定排序算法 | 时间复杂度(最好、最坏、平均)  
-|-|-|-|-
冒泡排序 | O(1) | 是 | 是 | O(n)、O(n^2)、O(n^2)
插入排序 | O(1) | 是 | 是 | O(n)、O(n^2)、O(n^2)
选择排序 | O(1) | 是 | 否 | O(n)、O(n^2)、O(n^2)

原地排序算法：空间复杂度为O(1)的排序算法

稳定排序算法：对于值相等的元素，排序不会改变其位置顺序的算法

有序度概念：
- 满有序度：数组中有序关系的元素对的最大值，即完全排好序的情况下的有序元素队值[n*(n-1)/2]
- 有序度：数组中具有有序关系的元素对的个数
- 逆序度：数组中没有有序关系的元素对的个数，值=满有序度-有序度

代码地址：https://github.com/wukunpdd/algorithm/blob/master/src/main/java/cn/wukun/SortTest.java
