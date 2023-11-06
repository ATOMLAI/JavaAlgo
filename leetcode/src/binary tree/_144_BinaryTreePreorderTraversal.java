import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */


/* 前序遍历->递归 */
public class _144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result){
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }
}
