package net.lll0.algor;

import net.lll0.algor.bean.ListNode;

public class AddTwoNumbers {


    public ListNode addTwo(ListNode l1, ListNode l2) {
        //缓存当使用的数据
        ListNode be = l1;
        ListNode aft = l2;

        //创建结果对象
        ListNode node = new ListNode(0);
        ListNode curr = node;

        //创建进位位
        int carry = 0;


        while (be != null || aft != null) {
            int beInt = be!=null?be.val:0;
            int aftInt = aft!=null?aft.val:0;
            carry = carry + beInt + aftInt;
            ListNode l = new ListNode(carry % 10);
            curr.next = l;
            curr = curr.next;
            carry = carry / 10;
            if (be != null) {
                be = be.next;
            }
            if (aft != null) {
                aft = aft.next;
            }
        }

        if (carry>0) {
            curr.next=new ListNode(carry);
        }

        return node.next;
    }




    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }



}
