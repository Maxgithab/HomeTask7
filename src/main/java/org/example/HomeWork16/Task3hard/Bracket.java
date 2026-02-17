package org.example.HomeWork16.Task3hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Bracket {

    public boolean bracketBalance(String string) {

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (int i = 0; i < string.length(); i++) {
            char data = string.charAt(i);

            if (data == '(' || data == '[' || data == '{') {
                stack.push(data);
            } else if (data == ')' || data == ']' || data == '}') {
                if (stack.isEmpty()) {
                    System.out.println("Лишняя закрывающая");
                    return false;
                }

                char last = stack.peek();
                if (last == pairs.get(data)) {
                    stack.pop();
                } else {
                    System.out.println("Несоответствие пары");
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Нехватка закрывающих скобок");
            return false;
        }
        System.out.println("Вроде норм");
        return true;
    }
}
