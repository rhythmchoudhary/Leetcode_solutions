public class Solution {
    public boolean isValidBST(TreeNode root) {
        return istree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean istree(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max)
            return false;

        return istree(node.left, min, node.val) &&
               istree(node.right, node.val, max);
    }
}




