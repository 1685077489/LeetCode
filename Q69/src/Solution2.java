/**牛顿法
 * @author WuTong
 * @create 2019-08-21 15:57
 */
public class Solution2 {
    public static int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(952));
    }
}
