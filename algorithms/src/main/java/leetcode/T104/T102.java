package leetcode.T104;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree,
 * return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            var level_size = queue.size();

            List<Integer> current_lever = new ArrayList<>();
            for (int i = 0; i < level_size; i++) {
                final TreeNode popTreeNode = queue.poll();

                if (popTreeNode != null){
                    current_lever.add(popTreeNode.val);
                }
                if (popTreeNode != null && popTreeNode.left != null) {
                    queue.offer(popTreeNode.left);
                }
                if (popTreeNode != null && popTreeNode.right != null) {
                    queue.add(popTreeNode.right);
                }
            }

            result.add(current_lever);
        }

        return result;
    }
}
