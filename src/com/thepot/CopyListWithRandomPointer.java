package com.thepot;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node h = head;

        while (h != null) {
            Node newH = new Node(h.val);

            newH.next = h.next;
            h.next = newH;

            h = h.next.next;

        }

        h = head;

        while (h != null) {
            if (h.random != null) {
                h.next.random = h.random.next;
            }

            h = h.next.next;

        }

        Node newH = head.next;
        Node p = newH;

        while (head != null) {
            head.next = head.next.next;
            if (p.next != null) {
                p.next = p.next.next;
            }

            p = p.next;
            head = head.next;
        }


        return newH;

    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}