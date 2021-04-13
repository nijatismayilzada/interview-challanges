package com.thepot;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode lp1 = l1.val < l2.val ? l1 : l2;
        ListNode lp2 = l1.val < l2.val ? l2 : l1;

        while (lp1.next != null && lp2 != null) {
            ListNode lp1N = lp1.next;
            ListNode lp2N = lp2.next;


            if (lp1N.val > lp2.val) {
                lp1.next = lp2;
                lp2.next = lp1N;

                lp1 = lp1.next;
                lp2 = lp2N;

            } else {
                lp1 = lp1.next;
            }
        }

        if (lp1.next == null) {
            lp1.next = lp2;
        }

        return l1.val < l2.val ? l1 : l2;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
