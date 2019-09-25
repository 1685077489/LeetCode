import java.util.Stack;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author WuTong
 * @create 2019-08-21 8:47
 */
public class Solution {
    public static int[] plusOne(int[] digits) {
        if (digits.length==0){
            return digits;
        }
        Stack<Integer> integers = new Stack<>();
        int temp = 0, num = 0;
        integers.add((digits[digits.length-1]+1)%10);
        temp = (digits[digits.length-1]+1)/10;
        for (int i = digits.length - 2; i >= 0; i--) {
            num = digits[i] + temp ;
            integers.add(num % 10);
            temp = num / 10;
        }
        if (temp > 0)
            integers.add(temp);
        int[] res = new int[integers.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = integers.pop();
        return res;
    }

    public static void main(String[] args) {
        int a[] = {1,9};
        int[] ints = plusOne(a);
        for (int n : ints) {
            System.out.println(n);
        }
    }
}
