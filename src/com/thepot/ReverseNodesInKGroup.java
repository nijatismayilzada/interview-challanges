package com.thepot;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,
                new ListNode(2, new ListNode(3)));

        ListNode aa = new ReverseNodesInKGroup().reverseKGroup(listNode, 3);

        System.out.println(aa);


    }


    public ListNode reverseKGroup(ListNode head, int k) {


        ListNode firstHead = null;
        ListNode bH = null;
        ListNode currHead = head;


        int i = 1;

        while (currHead != null) {


            if (i == k) {
                if (firstHead == null) {
                    firstHead = currHead;
                }

                i = 1;
                currHead = currHead.next;
                reverseGroup(bH, head, k);

                bH = head;
                head = currHead;

            } else {
                i++;
                currHead = currHead.next;
            }
        }

        return firstHead;

    }

    private void reverseGroup(ListNode bH, ListNode head, int k) {
        ListNode bT = head;
        ListNode tail = head.next;
        ListNode aT = null;
        if (tail != null) {
            aT = tail.next;
        }

        for (int i = 1; i < k; i++) {

            if (bH != null) {
                bH.next = tail;
            }

            tail.next = head;
            bT.next = aT;

            head = tail;

            tail = aT;
            if (tail != null && tail.next != null) {
                aT = tail.next;
            } else {
                aT = null;
            }
        }

    }


}
