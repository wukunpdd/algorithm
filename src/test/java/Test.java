/**
 * Created by wukun on 2019/5/28.
 */
public class Test {
    public static void main(String[] args){
        int n = 30;
        for(int i = 1; i <= n; i++){
            if(i == n){
                System.out.print(test(i));
                continue;
            }
            System.out.print(test(i) + ",");
        }
    }

    /**
     * 斐波那契数列(兔子数列)
     * 递推公式：f(n) = f(n-1) + f(n-2)
     * 递推终止条件：f(1) = 1,f(2) = 1
     */
    public static int test(int n){
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
}
