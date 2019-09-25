import java.util.ArrayList;
import java.util.List;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @author WuTong
 * @create 2019-08-21 16:07
 * 动态规划
 */
public class Solution {
    public static int climbStairs(int n) {
        List<Integer> list = new ArrayList<>();
        sol(n,list);
        return list.size();

    }

    private static void sol(int n, List<Integer> list) {
        if (n==0){
            list.add(1);
            return;
        }
        if (n>1){
            n-=2;
            sol(n,list);
            n+=2;
        }
        n-=1;
        sol(n,list);
    }

    public static void main(String[] args) {
        int i = climbStairs(37);
        System.out.println(i);
    }

}
