package huaifeng.leetcode.动态规划;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        for (String t : wordDict) {
            if (t.length()< len&& s.substring(0, t.length()).equals(t)) dp[0] =true;
        }
        // 内层可以从备选字典来写dp方程，也可以j=0 到i，在判断字典是否contains来写
        // i表示前i个字符。
        for (int i = 1; i <= len; i++) {
            for (String t : wordDict) {
                if ( i >= t.length() && !dp[i]) {
                    dp[i] = dp[i - t.length()] && s.substring( i - t.length(), i).equals(t);

                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        WordBreak139 wordBreak139 = new WordBreak139();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak139.wordBreak("leetcode", list);

    }
}
