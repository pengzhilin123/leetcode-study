package pzl.study;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 示例 1：
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
// 示例 2：
//输入：s = "cbbd"
//输出："bb"
//
// 示例 3：
//输入：s = "a"
//输出："a"
//
// 示例 4：
//输入：s = "ac"
//输出："a"
//
// 提示：
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 4098 👎 0
public class Demo0005 {
    public static void main(String[] args) {
        Demo0005 demo = new Demo0005();
        System.out.println(demo.longestPalindrome("bb"));
    }

    /**
     * 执行耗时:1463 ms,击败了5.01% 的Java用户
     * 内存消耗:39.1 MB,击败了49.71% 的Java用户
     */
    public String longestPalindrome_0(String s) {
        if (s.length() < 2 || isPalindrome(s)) return s;
        int max = -1;
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    int count = j - i;
                    if (count > max) {
                        max = count;
                        maxStr = s.substring(i, j + 1);
                    }
                }
            }
        }
        return maxStr;
    }

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 执行耗时:179 ms,击败了40.19% 的Java用户
     * 内存消耗:43 MB,击败了12.23% 的Java用户
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1,begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++)
            dp[i][i] = true;

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && L > maxLen) {
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
