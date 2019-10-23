package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;

public class A61_SerializeDeserialize {


    @Test
    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
//        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
//        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
//        n3.right = n7;
        String serialize = Serialize(n1);
        System.out.println(serialize);


        TreeNode deserialize = Deserialize(serialize);
        TreeUtility.printTreeOfLine(deserialize);
    }

    String ans = "";
    String Serialize(TreeNode root) {
        if (null == root) {
            ans += "#!";
            return ans;
        }
        ans += root.val + "!";
        Serialize(root.left);
        Serialize(root.right);
        return ans;
    }
    int pos = 0;
    TreeNode Deserialize(String str) {
        String[] split = str.split("!");
        if(pos >= split.length){
            return null;
        }
        if (split[pos].equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(split[pos]));
        pos++;
        node.left = Deserialize(str);
        pos ++;
        node.right = Deserialize(str);
        return node;
    }

}
