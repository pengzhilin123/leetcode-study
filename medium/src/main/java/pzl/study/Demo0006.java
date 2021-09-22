package pzl.study;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
// 请你实现这个将字符串进行指定行数变换的函数：
//string convert(string s, int numRows);
//
// 示例 1：
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
//
//示例 2：
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//
// 示例 3：
//输入：s = "A", numRows = 1
//输出："A"
//
// 提示：
// 1 <= s.length <= 1000
// s 由英文字母（小写和大写）、',' 和 '.' 组成
// 1 <= numRows <= 1000
//
// Related Topics 字符串
// 👍 1276 👎 0
public class Demo0006 {
    public static void main(String[] args) {
        Demo0006 demo = new Demo0006();
        System.out.println(demo.convert("PAYPALISHIRING", 3));
    }

    /**
     * 执行耗时:44 ms,击败了9.72% 的Java用户
     * 内存消耗:46.3 MB,击败了5.01% 的Java用户
     */
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len < 2 || numRows == 1) return s;
        int[][] numArea = new int[numRows][len];
        int index = 0, col = 0, row = 0;
        StringBuilder sb = new StringBuilder();
        while (index < len) {
            while (row < numRows && index < len) {
                numArea[row++][col] = s.charAt(index++);
            }
            row--;
            while (row > 1 && index < len) {
                numArea[--row][++col] = s.charAt(index++);
            }
            row--;
            col++;
        }
        for (int[] ints : numArea) {
            for (int j = 0; j < numArea[0].length; j++) {
                int c = ints[j];
                if (c != 0) {
                    sb.append((char) c);
                }
            }
        }
        return sb.toString();
    }

    public void printArea(int[][] area) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++) {
                int c = area[i][j];
                if (c == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print((char)c);
                }
            }
            System.out.println("");
        }
    }
}
