package com.sungpi.solutions;

//https://leetcode.com/problems/decode-string/
public class Solution394 {
    public class Token {
        String type;
        Token l;
        Token r;
    }

    public String decodeString(String s) {
        // parse string into tokens (number, string)
        // 3[a]2[bc]
        // 3 * a + 2 * bc
        // + * 3a * bc
        //           +
        //        *     *
        //       3  a  2  bc
        // 3[a]2[bc]
        // number[string]number[string]

        // *3a *2bc


        // 3[a2[c]]
        // number(string)
        // number(string number(string))

        // 3 * a2[c]
        // 3 * ( a + 2 * c)
        // 3 * acc
        //         *
        //       3    +
        //          a    *
        //             2   c

        //2[abc]3[cd]ef
        // number(string) number(string) string
        return "";
    }
}
/*
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */