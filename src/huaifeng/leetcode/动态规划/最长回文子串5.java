package huaifeng.leetcode.动态规划;

import javax.print.DocFlavor;

public class 最长回文子串5 {
    public String longestPalindrome(String s) {
        int sLen = s.length();
        String res = "";
        if (sLen == 0) return res;
        boolean[][] dp = new boolean[sLen][sLen];
        int max = 1;
        res = s.substring(0,1);
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
        }
        // 棋盘格左边为i，上面为j。一个点的状态来自左下，但是我们定i，动len，相当于动j，横着走。第一列的初始状态就没法确认了。
//        for (int i = 0; i < sLen; i++) {
//            for(int len = 1; i + len < sLen; len++) {
//                if (len == 1) {
//                    dp[i][i + len] = s.charAt(i) == s.charAt(i + len);
//                } else {
//                    dp[i][i + len] = dp[i+1][i+ len -1] && s.charAt(i) == s.charAt(i + len);
//                }
//                if (len + 1 > max && dp[i][i+len]) {
//                    res = s.substring(i, i+len+1);
//                    max =Math.max(len + 1, max);
//                }
//
//            }
//        }
        // 从i j表示子串开始结束位置。纵轴i 横轴j，如果采用ij循环，第一行要来自左下，这个还没有初始化。
        for (int j= 0; j < sLen; j++) {
            for (int i = 0; i < j; i++) {
                int len = j - i;
                if (len == 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else if(i+1 <= j-1){
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }

                if (len  + 1 > max && dp[i][j]) {
                    res = s.substring(i, j+1);
                    max = len + 1;
                }
            }
        }
//        // len为向右走几个位置。
//        for(int len = 1; len < sLen; len++) {
//            for (int i = 0; i + len < sLen; i++) {
//                if (len == 1) {
//                    dp[i][i + len] = s.charAt(i) == s.charAt(i + len);
//                } else {
//                    dp[i][i + len] = dp[i+1][i+ len -1] && s.charAt(i) == s.charAt(i + len);
//                }
//                if (len + 1 > max && dp[i][i+len]) {
//                    res = s.substring(i, i+len+1);
//                    max =Math.max(len + 1, max);
//                }
//            }
//        }
        return res;
    }

    public static void main(String[] args) {
        String s = "babad";
        最长回文子串5 t = new 最长回文子串5();
        String res =t.longestPalindrome(s);
        System.out.printf(res);

    }
}
