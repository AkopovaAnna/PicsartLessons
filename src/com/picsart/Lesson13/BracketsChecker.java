package com.picsart.Lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BracketsChecker {

    private static final List<Character> OPEN_BRACKETS = new ArrayList<>(Arrays.asList('{', '[', '('));
    private static final List<Character> CLOSE_BRACKETS = new ArrayList<>(Arrays.asList('}', ']', ')'));

    private static final Stack<Character> brackets = new Stack<>();

    public static boolean isValidBracket(String input) {

        if (!input.isEmpty()) {
            for (int i = 0; i < input.length(); i++) {
                if (OPEN_BRACKETS.contains(input.charAt(i))) {
                    brackets.push(input.charAt(i));

                } else {
                    if (CLOSE_BRACKETS.contains(input.charAt(i))) {
                        if (!brackets.isEmpty()) {
                            if (checkPair(brackets.peek(), input.charAt(i))) {
                                brackets.pop();
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
            return brackets.isEmpty();
        } else {
            return false;
        }

    }


    public static boolean checkPair(char openBracket, char closeBracket) {

        int openIndex = OPEN_BRACKETS.indexOf(openBracket);
        int closeIndex = CLOSE_BRACKETS.indexOf(closeBracket);
        return openIndex == closeIndex;
    }

    public static void main(String[] args) {
        String s = "{}pppp[]()";
        String ss = "]iii[{()ppp}]";
        System.out.println(isValidBracket(s));
        System.out.println(isValidBracket(ss));
    }
}
