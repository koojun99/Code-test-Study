import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수
        Map<String, TreeNode> map = new HashMap<>();
        TreeNode root = null;

        for (int i = 0; i < n; i++) {
            String val = sc.next();
            String left = sc.next();
            String right = sc.next();

            map.putIfAbsent(val, new TreeNode(val));
            TreeNode curr = map.get(val);

            if (i == 0) root = curr; // 첫 입력을 루트로

            if (!left.equals(".")) {
                map.putIfAbsent(left, new TreeNode(left));
                curr.left = map.get(left);
            }
            if (!right.equals(".")) {
                map.putIfAbsent(right, new TreeNode(right));
                curr.right = map.get(right);
            }
        }

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
    }

    static class TreeNode {
        String val;
        TreeNode left, right;
        TreeNode(String val) { this.val = val; }
    }

    static void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val);
        inorder(node.right);
    }

    static void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val);
    }
}