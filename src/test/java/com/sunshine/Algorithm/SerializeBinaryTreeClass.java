package com.sunshine.Algorithm;

import org.junit.Test;

public class SerializeBinaryTreeClass {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(11);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        serializeSolve(n1);
        System.out.println(stringBuilder.toString());

        String serialize = Serialize(n1);
        System.out.println(serialize);
        TreeNode deserialize = Deserialize(serialize);

        String result = Serialize(deserialize);
        System.out.println(result);
    }
    //自己的答案
    String Serialize(TreeNode root) {
        if (null == root) {
            return "#,";
        }
        StringBuilder sb = new StringBuilder(root.val + ",");
        String ls = Serialize(root.left);
        String rs = Serialize(root.right);
        sb.append(ls);
        sb.append(rs);
        return sb.toString();
    }

    int pos = 0;

    TreeNode Deserialize(String str) {
        String[] split = str.split(",");
        if (pos >= split.length || "#".equals(split[pos])) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(split[pos]));
        pos++;
        node.left = Deserialize(str);
        pos++;
        node.right = Deserialize(str);
        return node;
    }

    StringBuilder stringBuilder = new StringBuilder();

    private void serializeSolve(TreeNode cur) {
        if (null == cur) {
            stringBuilder.append("#,");
            return;
        }
        stringBuilder.append(cur.val + ",");
        serializeSolve(cur.left);
        serializeSolve(cur.right);
    }
}
