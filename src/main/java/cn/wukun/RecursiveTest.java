package cn.wukun;

import java.util.LinkedList;

/**
 * 递归算法练习(方法及函数命名较随意，不纠结)
 */
public class RecursiveTest {
    public static void main(String[] args){
        //斐波那契数列(兔子数列)测试
        int n = 30;
        for(int i = 1; i <= n; i++){
            if(i == n){
                System.out.println(rabbitQuestion(i));
                continue;
            }
            System.out.print(rabbitQuestion(i) + ",");
        }

        //汉诺塔问题测试
        n = 10;
        LinkedList<Integer> A = new LinkedList<>();
        for(int i = n; i >= 1; i--){
            A.push(i);
        }
        System.out.println("A:"+A);

        LinkedList<Integer> B = new LinkedList<>();
        LinkedList<Integer> C = new LinkedList<>();
        towerQuestion(A, B, C, n);

        System.out.println("B:"+B);
        System.out.println("C:"+C);
    }

    /**
     * 斐波那契数列(兔子数列)
     * 递推公式：f(n) = f(n-1) + f(n-2)
     * 递推终止条件：f(1) = 1,f(2) = 1
     */
    public static int rabbitQuestion(int n){
        if(n <= 2){
            return 1;
        }

        int index1 = 1;
        int index2 = 1;
        int result = 0;
        for(int i = 2; i < n; i++){
            result = index1 + index2;
            index1 = index2;
            index2 = result;
        }

        return result;
    }

    /**
     * 汉诺塔问题
     * A原盘 B借助盘 C目标盘
     * 核心思想(以此循环)：
     *  先移动level-1个盘子到借助盘上 借助目标盘
     *  将level盘移动到目标盘上
     *  将level-1个盘子从借助盘移动到目标盘上 借助源盘
     */
    public static void towerQuestion(LinkedList<Integer> A, LinkedList<Integer>  B, LinkedList<Integer>  C, int n){
        if(n == 1){
            C.push(A.pop());
        }else{
            towerQuestion(A, C, B,n-1);  //先移动level-1个盘子到借助盘上 借助目标盘
            C.push(A.pop());	//将level盘移动到目标盘上
            towerQuestion(B,A,C,n-1);	//将level-1个盘子从借助盘移动到目标盘上 借助源盘
        }
    }
}
