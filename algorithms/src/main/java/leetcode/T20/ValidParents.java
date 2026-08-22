package leetcode.T20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 * Input: parents = "()"
 * Output: true
 *
 * Example 2:
 * Input: parents = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: parents = "([}])"
 * Output: false
 */
public class ValidParents {
    public static boolean isValid(String parents) {
        Map<String, String> parentPair = new HashMap<>();
        parentPair.put("[", "]");
        parentPair.put("(", ")");
        parentPair.put("{", "}");
        Stack<String> stack = new Stack<>();

        for (String parent : parents.split("")) {
            if (parentPair.get(parent) != null) {
                stack.push(parent);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                String parentKey = stack.pop();
                if (!parent.equals(parentPair.get(parentKey))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()))"));
        System.out.println(isValid(")("));
        System.out.println(isValid("[]"));
        System.out.println(isValid("[)]"));
        System.out.println(isValid("[(]"));
    }
}
