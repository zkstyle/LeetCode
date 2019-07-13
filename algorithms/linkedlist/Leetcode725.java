package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-07-10 15:57
 * Description:
 */
public class Leetcode725 {

    public ListNode[] splitListToParts(ListNode root, int k) {

        int len = 0;
        ListNode node = root;
        while(node != null){
            len++;
            node = node.next;
        }
        ListNode [] res = new ListNode[k];
        int p = len / k;
        int mod = len % k;

        node = root;

        for(int i =0;i<k; i++){
            int l = p;
            if(mod > 0){
                l++;
                mod--;
            }
            ListNode start = node;
            while( l > 1 ){
                node = node.next;
                l--;
            }
            ListNode next = null;
            if(node != null){
                next = node.next;
                node.next = null;
            }
            node = next;
            res[i] = start;
        }
        return res;
    }
}
