package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A18_Mirror {

    @Test
    public void test(){
        TreeNode n1 =new TreeNode(1);
        TreeNode n2 =new TreeNode(2);
        TreeNode n3 =new TreeNode(3);
        TreeNode n4 =new TreeNode(4);
        TreeNode n5 =new TreeNode(5);
        TreeNode n6 =new TreeNode(6);
        TreeNode n7 =new TreeNode(7);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;

        Mirror(n1);
        TreeUtility.printTreeOfLine(n1);
    }


    public void Mirror(TreeNode root) {
        if(root == null ){
            return;
        }
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        Mirror(root.left);
        Mirror(root.right);
    }
}
