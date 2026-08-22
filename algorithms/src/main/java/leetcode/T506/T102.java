package leetcode.T506;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree,
 * return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 */
public class T102 {
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            var queue_size = queue.size();
            Integer currentLevMax = Integer.MIN_VALUE;

            for (int i = 0; i < queue_size; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode != null) {
                    if (currentNode.getVal() > currentLevMax) {
                        currentLevMax = currentNode.getVal();
                    }

                    if (currentNode.getLeft() != null) {
                        queue.offer(currentNode.getLeft());
                    }

                    if (currentNode.getRight() != null) {
                        queue.offer(currentNode.getRight());
                    }
                }
            }

            result.add(currentLevMax);
        }

        return result;
    }
}
