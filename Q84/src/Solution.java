/**
 * ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
 * ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������
 * ����: [2,1,5,6,2,3]
 * ���: 10
 *
 * @author WuTong
 * @create 2019-08-28 14:58
 */
public class Solution {
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i =0;i<heights.length;i++){
            int leftnum =0;
            int rightnum =0;
            for (int left = i;left>=0;left--){
                if (heights[left]<heights[i]){
                    break;
                }
                leftnum ++;
            }
            for (int right = i;right<heights.length;right++){
                if (heights[right]<heights[i]){
                    break;
                }
                rightnum ++;
            }
            res = Math.max(res,heights[i]*(leftnum+rightnum-1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(a));
    }
}
