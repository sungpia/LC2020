package com.sungpi.solutions;

public class Solution415 {
    public String addStrings(String num1, String num2) {
        int l = Math.max(num1.length(), num2.length());
        StringBuilder ret = new StringBuilder();
        StringBuilder n1 = new StringBuilder(num1);
        StringBuilder n2 = new StringBuilder(num2);

        if (num1.length() < l) {
            for (int i=0; i<l-num1.length(); ++i) {
                n1.insert(0, "0");
            }
        }

        if (num2.length() < l) {
            for (int i=0; i<l-num2.length(); ++i) {
                n2.insert(0, "0");
            }
        }

        // now we have same length;
        int c = 0;
        for (int i=l-1; i>=0; i--) {
            //parse
            int a = (int) n1.charAt(i) - 48;
            int b = (int) n2.charAt(i) - 48;

            int sum = a + b + c;
            if (sum > 9) {
                sum -= 10;
                c = 1;
            } else {
                c = 0;
            }

            ret.insert(0, (char) (sum+48));
        }
        if (c == 1) ret.insert(0, 1);
        return ret.toString();
    }
}

// case 1
// 01234
// 56706
// 294
// computation
// 492
// 60765
// 00075


// case 2

// ""
// "567"
// 567
