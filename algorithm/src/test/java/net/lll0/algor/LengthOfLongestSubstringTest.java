package net.lll0.algor;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthOfLongestSubstringTest {
    @Test
    public void lengthOfLongestSubstring() throws Exception {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String  t = "abcabcbb";
        int i = lengthOfLongestSubstring.lengthOfLongestSubstring(t);
        System.out.println(i);


    }

}