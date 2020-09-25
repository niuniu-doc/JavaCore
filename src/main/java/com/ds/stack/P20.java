package com.ds.stack;

import com.ds.stack.ArrayStack.ArrayStack;

public class P20 {
    public static void main(String[] args) throws Exception {
        String s1 = "()[]{}";
        String s2 = "()[]{}{";
        String s3 = "[()";
        System.out.println(new Solution().isValid(s1));
        System.out.println(new Solution().isValid(s2));
        System.out.println(new Solution().isValid(s3));
    }

     static class Solution {
        public  boolean isValid(String s) throws Exception{
            ArrayStack<Character> stack = new ArrayStack<>();
            for (int i=0; i< s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;

                    char topChar = stack.pop();
                    if ((c == ')' && topChar != '(') || (c == '[' && topChar != ']') || (c == '{' && topChar != '}'))
                        return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
