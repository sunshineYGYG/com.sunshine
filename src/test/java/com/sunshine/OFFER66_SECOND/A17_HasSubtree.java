package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A17_HasSubtree {

    @Test
    public void test(){
        TreeNode n1 =new TreeNode(1);
        TreeNode n2 =new TreeNode(2);
        TreeNode n3 =new TreeNode(3);
        TreeNode n4 =new TreeNode(4);
        TreeNode n5 =new TreeNode(5);
        TreeNode n6 =new TreeNode(6);
        TreeNode n7 =new TreeNode(7);
        TreeNode m1 =new TreeNode(2);
        TreeNode m2 =new TreeNode(4);
        TreeNode m3 =new TreeNode(5);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;

        m1.left=m2;
        m1.right=m3;

        boolean b = HasSubtree(n1, m1);
        System.out.println(b);
    }
    //考虑root2为null的情况
    boolean flag = true;
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(null == root2){
            if(flag){
                return false;
            }
            return true;
        }
        flag = false;
        if(null == root1){
            return false;
        }
        if(root1.val != root2.val){
            return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
        }else{
            return (HasSubtree(root1.left,root2.left)&&HasSubtree(root1.right,root2.right))||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
        }
    }

}
