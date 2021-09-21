package pzl.study;

//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
//
// 示例 1：
//输入：x = 121
//输出：true
//
// 示例 2：
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
// 示例 3：
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
//
// 示例 4：
//输入：x = -101
//输出：false
//
// 提示：
// -231 <= x <= 231 - 1
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学
// 👍 1617 👎 0
public class Demo0009 {
    /**
     * 执行耗时:18 ms,击败了7.36% 的Java用户
     * 内存消耗:38.3 MB,击败了8.45% 的Java用户
     */
    public boolean isPalindrome_0(int x) {
        StringBuilder sb = new StringBuilder("" + x);
        if (sb.toString().equals(sb.reverse().toString())) {
            return true;
        }
        return false;
    }

    /**
     * 执行耗时:17 ms,击败了9.30% 的Java用户
     * 内存消耗:37.4 MB,击败了97.69% 的Java用户
     */
    public boolean isPalindrome_1(int x) {
        String numStr = "" + x;
        int start = 0, end = numStr.length() -1;
        while(start < end) {
            if (numStr.charAt(start) != numStr.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 执行耗时:8 ms,击败了100.00% 的Java用户
     * 内存消耗:37.8 MB,击败了54.76% 的Java用户
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
