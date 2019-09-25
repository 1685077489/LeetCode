import java.util.ArrayList;
import java.util.List;

/**
 * @author WuTong
 * @create 2019-08-21 16:25
 */
public class Solution2 {
    public static int climbStairs(int n) {
        int i=1,j=2;
        int res = 0;
        if (n==1)
            return 1;
        else if (n==2)
            return 2;
        while (n>2){
            res=i+j;
            i=j;
            j=res;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}
