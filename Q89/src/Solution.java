import java.util.ArrayList;
import java.util.List;

/**
 * ���ױ�����һ������������ϵͳ���ڸ�ϵͳ�У�������������ֵ����һ��λ���Ĳ��졣
 * ����һ�����������λ���ķǸ����� n����ӡ����ױ������С����ױ������б����� 0 ��ͷ��
 * ʾ�� 1:
 * ����:?2
 * ���:?[0,1,3,2]
 * ����:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * ���ڸ�����?n������ױ������в���Ψһ��
 * ���磬[0,2,3,1]?Ҳ��һ����Ч�ĸ��ױ������С�
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * ʾ��?2:
 * ����:?0
 * ���:?[0]
 * ����: ���Ƕ�����ױ������б����� 0 ��ͷ��
 * ?    ����������λ��Ϊ n �ĸ��ױ������У��䳤��Ϊ 2n���� n = 0 ʱ������Ϊ 20 = 1��
 * ?    ��ˣ��� n = 0 ʱ������ױ�������Ϊ [0]��
 *
 * @author WuTong
 * @create 2019-09-01 10:23
 * ��n0->n1;n1->n2;n2->n3
 */
public class Solution {
    public static List<Integer> grayCode(int n) {
        List<Integer> demo = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        demo.add(0);
        for (int i = 0; i < n; i++) {
            for (int j =0;j<demo.size();j++){
                res.add(demo.get(j));
            }
            for (int j=demo.size()-1;j>=0;j--){
                res.add(demo.get(j)+new Double(Math.pow(2,i)).intValue());
            }
            demo =new ArrayList<>(res);
            res.removeAll(res);
        }
        return demo;
    }

    public static void main(String[] args) {
        for (Integer integer : grayCode(4)) {
            System.out.println(integer);
        }

    }
}
