package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A58_isSymmetrical {

    @Test
    public void test(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        boolean symmetrical = isSymmetrical(n1);
        System.out.println(symmetrical);
    }


    boolean isSymmetrical(TreeNode pRoot) {
        if (null == pRoot) {
            return true;
        }
        return judge(pRoot.left, pRoot.right);
    }

    boolean judge(TreeNode pos1, TreeNode pos2) {
        if (null == pos1 && null == pos2) {
            return true;
        }
        if (null == pos1 || null == pos2) {
            return false;
        }
        if (pos1.val != pos2.val) {
            return false;
        }
        return judge(pos1.left,pos2.right)&&judge(pos1.right,pos2.left);
    }
}
