import java.util.Stack;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author WuTong
 * @create 2019-08-21 9:38
 */
public class Solution {
    public static String addBinary(String a, String b) {
        Stack<Integer> integers = new Stack<>();
        int temp = 0,num;
        int num2 = Math.abs(a.length()-b.length());
        String res= "";
        if(a.length()-b.length()>=0){
            for (int i =0;i< num2;i++){
                b = "0"+b;
            }
        }else {
            for (int i =0;i< num2;i++){
                a = "0"+a;
            }
        }
        for (int i = a.length()-1;i>=0;i--){
            num =Integer.parseInt(a.substring(i,i+1))+Integer.parseInt(b.substring(i,i+1))+temp;
            integers.add(num%2);
            temp = num/2;
        }
        if (temp>0)
            integers.add(temp);

        while (!integers.isEmpty())
            res+=integers.pop();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("111","11"));

    }
}
