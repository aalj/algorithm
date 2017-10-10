package net.lll0.algor;

public class LengthOfLongestSubstring {


    /*
    Given a string, find the length of the longest substring without repeating characters.

    Examples:

        Given "abcabcbb", the answer is "abc", which the length is 3.

        Given "bbbbb", the answer is "b", with the length of 1.

        Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public int lengthOfLongestSubstring(String s) {
        int  maxLength = 0 ;
        int [] index = new int[128];
        int len = s.length();
        //记录当前最后一个重复的字符的下标
        int repeat = 0;
        for (int i = 0; i < len; i++) {
            //比较当前的字符是是都是存在重复的字符， 并替换下标
            repeat = Math.max(index[s.charAt(i)],repeat);

            maxLength = Math.max(maxLength,i-repeat+1);
            //存储当前字符的下标到数组对应的位置
            index[s.charAt(i)]=i+1;
        }

        return maxLength;
    }



















    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


}
