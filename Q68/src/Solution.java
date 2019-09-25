import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 说明:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 * "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * @author WuTong
 * @create 2019-08-21 10:07
 */
public class Solution {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        int length = words[0].length();
        List<String> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            length += words[i].length() + 1;
            if (length > maxWidth) {
                res.add(change(list, maxWidth ,0));
                list.removeAll(list);
                list.add(words[i]);
                length = words[i].length();
                continue;
            }
            list.add(words[i]);
        }
        res.add(change(list, maxWidth ,1));
        return res;
    }

    public static String change(List<String> list, int maxWidth, int e) {
        int length = 0;
        String res = "";
        for (String s : list) {
            length += s.length();
        }
        if (list.size()==1){
            return add(list.get(0),maxWidth-length);
        }
        if (e==1){//最后一行，左对齐
            for (int i = 0;i<list.size()-1;i++){
                res+=(list.get(i)+" ");
            }
            res+=list.get(list.size()-1);
            return add(res,maxWidth-res.length());

        }
        int num = (maxWidth - length) / (list.size() - 1);
        int num2 = (maxWidth - length) % (list.size() - 1);
        for (int i = 0; i < list.size() - 1; i++) {
            if (i < num2) {
                list.set(i, add(list.get(i), num + 1));
                continue;
            }
            list.set(i, add(list.get(i), num));
        }
        for (String l:list) {
            res+=l;
        }
        return res;
    }

    private static String add(String s, int i) {
        while (i > 0) {
            s += " ";
            i--;
        }

        return s;
    }

    public static void main(String[] args) {
        String[] a = {"Science","is","what","we","understand","well","enough","to","explain", "to","a","computer.","Art",
                "is","everything","else","we","do","do","do"};
        List<String> list = fullJustify(a, 20);
        for (String l : list) {
            System.out.println(l);
        }

    }
}
