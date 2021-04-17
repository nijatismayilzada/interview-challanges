package com.thepot;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }


        ListNode tail = head.next;
        ListNode bT = head;
        ListNode aT = tail.next;

        while(true){

            tail.next = head;
            bT.next = null;

            head = tail;
            tail = aT;

            if(tail == null){
                break;
            }

            aT = tail.next;
        }

        return head;



    }



}
