package leetcode.T104;

import java.util.Stack;

/**'
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes
 * along the longest path from the root node down to the farthest leaf node.
 */
public class T104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth1(TreeNode root) {
        record Pair(TreeNode node, int depth) {}

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));   // stack = [(root, 1)]
        int result = 0;

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            TreeNode node = p.node();
            int depth = p.depth();

            if (node == null) {     // if not node: continue
                continue;
            }

            result = Math.max(result, depth);
            stack.push(new Pair(node.left,  depth + 1));
            stack.push(new Pair(node.right, depth + 1));
        }

        return result;
    }
}
