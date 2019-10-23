package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A57_GetNext {

    @Test
    public void test() {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.next = n1;
        n2.left = n4;
        n2.right = n5;
        n3.next = n1;
        n3.left = n6;
        n3.right = n7;
        n4.next = n2;
        n5.next = n2;
        n6.next = n3;
        n7.next = n3;
        TreeLinkNode treeLinkNode = GetNext(n7);
        System.out.println(null==treeLinkNode?"null":treeLinkNode.val);
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode ans = null;
        if (pNode.right != null) {
            ans = pNode.right;
            while (ans.left != null) {
                ans = ans.left;
            }
            return ans;
        }
        if (pNode.next != null) {
            ans = pNode.next;
            if (ans.left == pNode) {
                return ans;
            }
            while (null != ans && ans.right != null) {
                if (ans.left == pNode) {
                    return ans;
                }
                pNode = ans;
                ans = ans.next;
            }
            return ans;
        }
        return ans;
    }
}
