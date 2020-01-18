package com.sungpi.solutions;

import java.util.HashMap;
import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (char a : s.toCharArray()) {
            if (a == '(') {
                stack.push(a);
            } else if (a == '{') {
                stack.push(a);
            } else if (a == '[') {
                stack.push(a);
            } else if (a == ')' || a == '}' || a == ']') {
                char b = map.get(stack.pop());
                if ( b != a) return false;
            }
        }
        if (stack.size() > 0) return false;
        return true;
    }
}
